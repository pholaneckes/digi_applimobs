package gq.codephon.digi_applimobs.commnds;

import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import gq.codephon.digi_applimobs.util.varia.AppliDenShiNouRyoku;
import gq.codephon.digi_applimobs.util.varia.CapRegHandler;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static gq.codephon.digi_applimobs.event.test.CapTest.serverPackSend;

@Mod.EventBusSubscriber
public class DSNR_Command {
    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event) {
        event.getDispatcher().register(LiteralArgumentBuilder.<CommandSource>literal("dsnrto").requires((tho) -> tho.hasPermission(2))
            .then(Commands.literal("add")
            .then(Commands.argument("count", FloatArgumentType.floatArg(0.0f))
            .executes(arg -> {
            Entity entity = arg.getSource().getEntity();
                if (entity instanceof PlayerEntity) {
                    add(FloatArgumentType.getFloat(arg.copyFor(arg.getSource()),"count"), (PlayerEntity) entity);
                }
                return 0;
        })))
            .then(Commands.literal("take")
            .then(Commands.argument("count", FloatArgumentType.floatArg(0.0f))
            .executes(arg -> {
                Entity entity = arg.getSource().getEntity();
                if (entity instanceof PlayerEntity) {
                    take(FloatArgumentType.getFloat(arg.copyFor(arg.getSource()),"count"), (PlayerEntity) entity);
                }
                return 0;

        })))
            .then(Commands.literal("player")
            .then(Commands.literal("take")
            .then(Commands.argument("count", FloatArgumentType.floatArg(0.0f))
            .then(Commands.argument("player", EntityArgument.entity())
            .executes(arg ->{
                PlayerEntity player = EntityArgument.getPlayer(arg.copyFor(arg.getSource()), "player");
                take(FloatArgumentType.getFloat(arg.copyFor(arg.getSource()),"count"),player);
                bal(player);
                return 0;
            }))
            ))
            .then(Commands.literal("add")
            .then(Commands.argument("count", FloatArgumentType.floatArg(0.0f))
            .then(Commands.argument("player", EntityArgument.entity())
            .executes(arg ->{
                PlayerEntity player = EntityArgument.getPlayer(arg.copyFor(arg.getSource()), "player");
                add(FloatArgumentType.getFloat(arg.copyFor(arg.getSource()),"count"),player);
                bal(player);
                return 0;
            }))
            ))
            .then(Commands.literal("bal")
            .then(Commands.argument("player", EntityArgument.entity())
            .executes(arg->{
                Entity entity = arg.getSource().getEntity();
                PlayerEntity player = EntityArgument.getPlayer(arg.copyFor(arg.getSource()), "player");
                bal(player,(PlayerEntity) entity);
                return 0;
            }))
            ))
    );
        event.getDispatcher().register(LiteralArgumentBuilder.<CommandSource>literal("dsnr").requires((tho) -> tho.hasPermission(0))
                .then(Commands.literal("bal").executes(arg->{
                    Entity entity = arg.getSource().getEntity();
                    if (entity instanceof PlayerEntity) {
                        bal((PlayerEntity) entity);
                    }
                    return 0;
                })));
}

    public static void add(float val, PlayerEntity player){
        LazyOptional<AppliDenShiNouRyoku> capability = player.getCapability(CapRegHandler.DENSHINOURYOKU);
        capability.ifPresent(cpb -> {
            cpb.setDenSNR(cpb.getDenSNR()+val);
            serverPackSend(player,cpb);
        });
    }

    public static void take(float val, PlayerEntity player){
        LazyOptional<AppliDenShiNouRyoku> capability = player.getCapability(CapRegHandler.DENSHINOURYOKU);
        capability.ifPresent(cpb -> {
            cpb.setDenSNR(cpb.getDenSNR()-val);
            serverPackSend(player,cpb);
        });
    }

    public static void bal(PlayerEntity player){
        LazyOptional<AppliDenShiNouRyoku> capability = player.getCapability(CapRegHandler.DENSHINOURYOKU);
        capability.ifPresent(cpb -> {
        player.sendMessage(new StringTextComponent(new TranslationTextComponent("color.o").getString()+new TranslationTextComponent("color.e").getString()+player.getName().getString() + "' "+new TranslationTextComponent("color.r").getString() + new TranslationTextComponent("msg.show.dsnr").getString()+ cpb.getDenSNR()),player.getUUID());
        });
    }

    public static void bal(PlayerEntity player, PlayerEntity sendFor){
        LazyOptional<AppliDenShiNouRyoku> capability = player.getCapability(CapRegHandler.DENSHINOURYOKU);
        capability.ifPresent(cpb -> {
            sendFor.sendMessage(new StringTextComponent(new TranslationTextComponent("color.o").getString()+new TranslationTextComponent("color.e").getString()+player.getName().getString() + "' "+new TranslationTextComponent("color.r").getString() + new TranslationTextComponent("msg.show.dsnr").getString()+ cpb.getDenSNR()),player.getUUID());
        });
    }
}
