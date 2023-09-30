package gq.codephon.digi_applimobs.util;

import net.minecraft.entity.Entity;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.vector.Vector3d;

import net.minecraft.world.World;
import net.minecraftforge.entity.PartEntity;

import java.util.Iterator;
import java.util.function.Predicate;

public class Ways {
    public static Entity getPointedEntity(Entity entity, double distance) {
        return getPointedEntity(entity, distance, null);
    }
    public static Entity getCoreEntity(Entity in) {
        return in instanceof PartEntity ? ((PartEntity)in).getParent() : in;
    }

    public static Entity getPointedEntity(Entity entity, double distance, Predicate<Entity> selector) {
        Vector3 pos = Vector3.getNewVector().set(entity, true);
        Vector3 loc = getPointedLocation(entity, distance);
        if (loc != null) {
            distance = loc.distanceTo(pos);
        }

        Vector3d vec31 = entity.getViewVector(0.0F);
        Predicate<Entity> predicate = EntityPredicates.NO_SPECTATORS.and((c) -> entity.isPickable());
        if (selector != null) {
            predicate = predicate.and(selector);
        }

        predicate = predicate.and((c) -> !c.isSpectator() && c.isAlive() && c.isPickable() && !isRidingOrRider(entity, c));
        Entity hit = pos.firstEntityExcluding(distance, vec31, entity.getCommandSenderWorld(), entity, predicate);
        if (hit != null) {
            hit = getCoreEntity(hit);
        }

        return hit;
    }

    public static Vector3 getPointedLocation(Entity entity, double distance) {
        Vector3d vec3 = new Vector3d(entity.getX(), entity.getY() + (double)entity.getEyeHeight(), entity.getZ());
        Vector3d vec31 = entity.getViewVector(0.0F);
        Vector3d vec32 = vec3.add(vec31.x * distance, vec31.y * distance, vec31.z * distance);
        World world = entity.getCommandSenderWorld();
        BlockRayTraceResult result = world.clip(new RayTraceContext(vec3, vec32, RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.NONE, entity));
        return Vector3.getNewVector().set(result.getLocation());
    }

    public static boolean isRidingOrRider(Entity a, Entity b) {
        Iterator<Entity> var2 = a.getIndirectPassengers().iterator();//184182_bu().iterator();

        Entity c;
        do {
            if (!var2.hasNext()) {
                var2 = b.getIndirectPassengers().iterator();

                do {
                    if (!var2.hasNext()) {
                        return false;
                    }

                    c = var2.next();
                } while(!a.equals(c));

                return true;
            }

            c = var2.next();
        } while(!b.equals(c));

        return true;
    }
}
