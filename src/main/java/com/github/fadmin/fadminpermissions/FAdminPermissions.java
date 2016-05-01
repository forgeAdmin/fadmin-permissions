package com.github.fadmin.fadminpermissions;

import com.github.fadmin.fadminpermissions.common.CommonProxy;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;

@Mod(modid = "fadminpermissions", name = "fAdmin Permissions")
public class FAdminPermissions {

  @Mod.Instance("fadminpermissions")
  public static FAdminPermissions INSTANCE;

  @Mod.Metadata
  public static ModMetadata meta;

  @SidedProxy(clientSide = "com.github.fadmin.fadminpermissions.client.ClientProxy",
      serverSide = "com.github.fadmin.fadminpermissions.common.CommonProxy")
  public static CommonProxy proxy;

  public static boolean isServer() {
    return FMLCommonHandler.instance().getEffectiveSide().isServer();
  }

  public static boolean isClient() {
    return FMLCommonHandler.instance().getEffectiveSide().isClient();
  }

  @Mod.EventHandler
  public void preload(FMLPreInitializationEvent event) {
    proxy.preload(event);
  }

  @Mod.EventHandler
  public void load(FMLInitializationEvent event) {
    proxy.load(event);
  }

  @Mod.EventHandler
  public void postload(FMLPostInitializationEvent event) {
    proxy.postload(event);
  }

  @Mod.EventHandler
  public void serverStarted(FMLServerAboutToStartEvent event) {
    proxy.serverAboutToStart(event);
  }

  @Mod.EventHandler
  public void serverStarted(FMLServerStartedEvent event) {
    proxy.serverStarted(event);
  }

  @Mod.EventHandler
  public void serverStarted(FMLServerStoppedEvent event) {
    proxy.serverStopped(event);
  }
}