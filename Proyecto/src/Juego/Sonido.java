

package Juego;

import java.applet.Applet;
import java.applet.AudioClip;

public class Sonido {
    public static final AudioClip BALL = Applet.newAudioClip(Sonido.class.getResource("ball.wav"));
	public static final AudioClip GAMEOVER = Applet.newAudioClip(Sonido.class.getResource("gameover.wav"));
	public static final AudioClip BACK = Applet.newAudioClip(Sonido.class.getResource("back.wav"));
}
