package eu.minemania.mobcountmod;

import eu.minemania.mobcountmod.config.Configs;
import eu.minemania.mobcountmod.counter.DataManager;
import eu.minemania.mobcountmod.event.InputHandler;
import eu.minemania.mobcountmod.event.KeyCallbacks;
import eu.minemania.mobcountmod.event.RenderHandler;
import fi.dy.masa.malilib.config.ConfigManager;
import fi.dy.masa.malilib.event.InputEventHandler;
import fi.dy.masa.malilib.event.RenderEventHandler;
import fi.dy.masa.malilib.interfaces.IInitializationHandler;
import fi.dy.masa.malilib.interfaces.IRenderer;
import net.minecraft.client.Minecraft;

public class InitHandler implements IInitializationHandler 
{
    @Override
    public void registerModHandlers()
    {
        ConfigManager.getInstance().registerConfigHandler(Reference.MOD_ID, new Configs());

        InputEventHandler.getKeybindManager().registerKeybindProvider(InputHandler.getInstance());
        InputEventHandler.getInputManager().registerKeyboardInputHandler(InputHandler.getInstance());
        InputEventHandler.getInputManager().registerMouseInputHandler(InputHandler.getInstance());

        IRenderer renderer = new RenderHandler();
        RenderEventHandler.getInstance().registerGameOverlayRenderer(renderer);

        KeyCallbacks.init(Minecraft.getInstance());

        DataManager.getInstance().init();
    }
}
