package gq.codephon.digi_applimobs.util;

import net.minecraft.entity.Entity;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.GlobalPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.entity.PartEntity;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Vector3 {
    public double x;
    public double y;
    public double z;

    public static Vector3 entity(Entity e) {
        return e != null ? getNewVector().set(e.getX(), e.getY() + (double)e.getEyeHeight(), e.getZ()) : null;
    }

    public static Vector3 getNewVector() {
        return new Vector3();
    }

    private Vector3() {
        this.x = this.y = this.z = 0.0;
    }

    public Vector3 add(double i, double j, double k) {
        return getNewVector().set(this.x + i, j + this.y, k + this.z);
    }

    public void add(int i, double j) {
        if (i == 0) {
            this.x += j;
        } else if (i == 1) {
            this.y += j;
        } else if (i == 2) {
            this.z += j;
        }

    }

    public Vector3 add(Vector3 vectorB) {
        Vector3 vectorC = getNewVector();

        for(int i = 0; i < 3; ++i) {
            vectorC.set(i, this.get(i) + vectorB.get(i));
        }

        return vectorC;
    }


    public double distanceTo(Vector3 vec) {
        return this.subtract(vec).mag();
    }

    public boolean equals(Object vec) {
        if (!(vec instanceof Vector3)) {
            return false;
        } else {
            Vector3 v = (Vector3)vec;
            return v.x == this.x && v.y == this.y && v.z == this.z;
        }
    }

    public Entity firstEntityExcluding(double range, Vector3d vec31, World world, Entity entity, Predicate<Entity> predicate) {
        Entity pointedEntity = null;
        if (predicate == null) {
            predicate = EntityPredicates.NO_SPECTATORS;
        }

        Vector3d vec3 = this.toVec3d();
        Vector3d vec32 = vec3.add(vec31.x * range, vec31.y * range, vec31.z * range);
        float f = 2.5F;
        AxisAlignedBB aabb = this.getAABB().expandTowards(vec31.x * range, vec31.y * range, vec31.z * range).inflate(2.5, 2.5, 2.5);
        List<Entity> mobs = world.getEntities(entity, aabb, predicate); //?
        double ds = range * range;
        PartEntity<?>[] parts;
        Iterator var16 = mobs.iterator();

        while(true) {
            while(true) {
                while(var16.hasNext()) {
                    Entity entity1 = (Entity)var16.next();
                    if ((parts = entity1.getParts()) != null && parts.length > 0) {
                        PartEntity[] var26 = parts;
                        int var27 = parts.length;

                        for(int var28 = 0; var28 < var27; ++var28) {
                            PartEntity<?> part = var26[var28];
                            AxisAlignedBB axisalignedbb = part.getBoundingBox().inflate(0.30000001192092896);
                            Optional<Vector3d> optional = axisalignedbb.clip(vec3, vec32);  //?
                            if (optional.isPresent()) {
                                double d1 = vec3.distanceToSqr(optional.get());
                                if (d1 < ds) {
                                    pointedEntity = entity1;
                                    ds = d1;
                                    break;
                                }
                            }
                        }
                    } else {
                        AxisAlignedBB axisalignedbb = entity1.getBoundingBox().inflate(0.30000001192092896);
                        Optional<Vector3d> optional = axisalignedbb.clip(vec3, vec32);
                        if (optional.isPresent()) {
                            double d1 = vec3.distanceToSqr(optional.get());
                            if (d1 < ds) {
                                pointedEntity = entity1;
                                ds = d1;
                            }
                        }
                    }
                }

                return pointedEntity;
            }
        }
    }

    public Vector3d toVec3d() {
        return new Vector3d(this.x, this.y, this.z);
    }

    public double get(int i) {
        assert i < 3;

        return i == 0 ? this.x : (i == 1 ? this.y : this.z);
    }

    public AxisAlignedBB getAABB() {
        return new AxisAlignedBB(this.x, this.y, this.z, this.x, this.y, this.z);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public double mag() {
        double vmag = Math.sqrt(this.magSq());
        return vmag;
    }

    public double magSq() {
        return this.x * this.x + this.y * this.y + this.z * this.z;
    }


    public Vector3 set(Direction dir) {
        this.x = dir.getStepX();
        this.y = dir.getStepY();
        this.z = dir.getStepZ();
        return this;
    }

    public Vector3 set(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    public Vector3 set(double[] vec) {
        this.x = vec[0];
        this.y = vec[1];
        this.z = vec[2];
        return this;
    }

    public Vector3 set(Entity e, boolean b) {
        if (e != null && b) {
            this.x = e.getX();
            this.y = e.getY() + (double)(e.getBbHeight() / 2.0F);
            this.z = e.getZ();
        } else if (e != null) {
            this.x = e.getX();
            this.y = e.getY() + (double)e.getEyeHeight();
            this.z = e.getZ();
        }

        return this;
    }

    public void set(int i, double j) {
        if (i == 0) {
            this.x = j;
        } else if (i == 1) {
            this.y = j;
        } else if (i == 2) {
            this.z = j;
        }

    }

    public Vector3 set(Object o) {
        if (o instanceof Entity) {
            Entity e = (Entity)o;
            this.set(e.getX(), e.getY(), e.getZ());
        } else if (o instanceof TileEntity) {
            TileEntity te = (TileEntity)o;
            this.set(te.getBlockPos());
        } else if (o instanceof double[]) {
            double[] d = (double[]) o;
            this.set(d[0], d[1], d[2]);
        } else if (o instanceof Direction) {
            Direction side = (Direction)o;
            this.set(side.getStepX(), side.getStepY(), side.getStepZ());
        } else if (o instanceof Vector3) {
            this.set((Vector3)o);
        } else {
            BlockPos c;
            if (o instanceof BlockPos) {
                c = (BlockPos)o;
                this.set(c.getX(), c.getY(), c.getZ());
            } else if (o instanceof GlobalPos) {
                c = ((GlobalPos)o).pos();
                this.set(c.getX(), c.getY(), c.getZ());
            } else if (o instanceof PathPoint) {
                PathPoint p = (PathPoint)o;
                this.set(p.x, p.y, p.z);
            } else if (o instanceof Vector3d) {
                Vector3d p = (Vector3d)o;
                this.set(p.x, p.y, p.z);
            } else if (o instanceof int[]) {
                int[] p = (int[]) o;
                this.set(p[0], p[1], p[2]);
            } else if (o instanceof byte[]) {
                byte[] p = (byte[]) o;
                this.set(p[0], p[1], p[2]);
            } else if (o instanceof short[]) {
                short[] p = (short[]) o;
                this.set(p[0], p[1], p[2]);
            } else if (o instanceof Double) {
                this.x = this.y = this.z = (Double)o;
            }
        }

        return this;
    }

    public Vector3 set(Vector3 vec) {
        if (vec != null) {
            this.x = vec.x;
            this.y = vec.y;
            this.z = vec.z;
        }

        return this;
    }

    public Vector3 subtract(Vector3 vectorB) {
        Vector3 vectorC = getNewVector();

        for(int i = 0; i < 3; ++i) {
            vectorC.set(i, this.get(i) - vectorB.get(i));
        }

        return vectorC;
    }

    public String toString() {
        return "x:" + this.x + " y:" + this.y + " z:" + this.z;
    }

        public void set(int x0, int y0, int z0) {
            this.x = x0;
            this.y = y0;
            this.z = z0;
        }

    }

