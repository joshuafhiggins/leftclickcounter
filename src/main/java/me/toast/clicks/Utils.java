package me.toast.clicks;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiTextField;

import java.awt.*;

public class Utils {

    public static void DrawLeftClicks(float brightness) {
        String string = Clicks.SETTINGS.getLeftPrefix() + Clicks.SETTINGS.getLeftClicks();
        Minecraft mc = Minecraft.getMinecraft();
        FontRenderer fr = mc.fontRendererObj;

        for (int i = 0; i < string.length(); i++) {
            if (mc.theWorld != null && mc.currentScreen == null) {
                if (Clicks.SETTINGS.getLeftChroma()) { fr.drawString(string, Clicks.SETTINGS.getLeftPos()[0], Clicks.SETTINGS.getLeftPos()[1], RainbowEffect(i * 3500000L, brightness, 250).getRGB(), Clicks.SETTINGS.getLeftShadow()); }
                else { fr.drawString(string, Clicks.SETTINGS.getLeftPos()[0], Clicks.SETTINGS.getLeftPos()[1], GetCustomColor().getRGB(), Clicks.SETTINGS.getLeftShadow()); }
            }
        }
    }
    public static Color RainbowEffect(long offset, float brightness, int speed) {
        float hue = (float) (System.nanoTime() + (offset * speed)) / 1.0E10F % 1.0F;
        long color = Long.parseLong(Integer.toHexString(Color.HSBtoRGB(hue, brightness, 1F)), 16);
        Color c = new Color((int) color);
        return new Color(c.getRed()/255.0F, c.getGreen()/255.0F, c.getBlue()/255.0F, c.getAlpha()/255.0F);
    }

    public static Color GetCustomColor() {
        return new Color(Clicks.SETTINGS.getLeftColor());
    }

    public static boolean TextFieldIntersect(GuiTextField field, int mouseX, int mouseY) {
        return mouseX >= field.xPosition
                && mouseX <= field.xPosition + field.width
                && mouseY >= field.yPosition
                && mouseY <= field.yPosition + field.height;
    }
    public static void CheckForUpdates() {
        return; //TODO
    }
}
