package baubles.common.network;

import baubles.api.BaublesApi;
import baubles.api.cap.BaublesContainer;
import baubles.api.cap.IBaublesItemHandler;
import baubles.common.Baubles;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Sync slots while loading the gui.
 **/
public class PacketSyncSlotCounts implements IMessage, IMessageHandler<PacketSyncSlotCounts, IMessage> {

    private int playerId;
    private NBTTagCompound compound;

    public PacketSyncSlotCounts() {
    }

    public PacketSyncSlotCounts(EntityLivingBase p, NBTTagCompound compound) {
        playerId = p.getEntityId();
        this.compound = compound;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        playerId = buf.readInt();
        NBTTagCompound tag = ByteBufUtils.readTag(buf);
        if (tag == null) return;
        this.compound = tag;
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(playerId);
        ByteBufUtils.writeTag(buf, this.compound);
    }

    @Override
    public IMessage onMessage(PacketSyncSlotCounts message, MessageContext ctx) {
        Minecraft.getMinecraft().addScheduledTask(new SyncTask(message));
        return null;
    }

    @SideOnly(Side.CLIENT)
    private static class SyncTask implements Runnable {

        private final PacketSyncSlotCounts message;

        public SyncTask(PacketSyncSlotCounts message) {
            this.message = message;
        }

        @Override
        public void run() {
            World world = Baubles.proxy.getClientWorld();
            if (world == null) return;

            Entity p = world.getEntityByID(message.playerId);
            if (p instanceof EntityLivingBase) {
                IBaublesItemHandler baubles = BaublesApi.getBaublesHandler((EntityLivingBase) p);
                if (!(baubles instanceof BaublesContainer)) return;
                ((BaublesContainer) baubles).deserializeNBT(message.compound);
            }
        }
    }
}
