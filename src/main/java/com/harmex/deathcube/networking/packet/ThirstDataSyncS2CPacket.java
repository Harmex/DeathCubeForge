package com.harmex.deathcube.networking.packet;

import com.harmex.deathcube.thirst.ClientThirstData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ThirstDataSyncS2CPacket {
    private final int thirst;
    private final int thirstSaturation;

    public ThirstDataSyncS2CPacket(int thirst, int thirstSaturation) {
        this.thirst = thirst;
        this.thirstSaturation = thirstSaturation;
    }

    public ThirstDataSyncS2CPacket(FriendlyByteBuf buf) {
        this.thirst = buf.readInt();
        this.thirstSaturation = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(thirst);
        buf.writeInt(thirstSaturation);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // HERE WE ARE ON THE CLIENT!
            ClientThirstData.set(thirst, thirstSaturation);
        });
        return true;
    }
}
