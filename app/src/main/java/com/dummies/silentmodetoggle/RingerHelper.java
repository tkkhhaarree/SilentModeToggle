package com.dummies.silentmodetoggle;

/**
 * Created by DELL on 1/23/2017.
 */
import android.media.AudioManager;

public class RingerHelper {
    private RingerHelper() {
    }

    public static void performToggle(AudioManager audioManager) {
// If the phone is currently silent, then unsilence it. If
// it's currently normal, then silence it.
        audioManager.setRingerMode(
                isPhoneSilent(audioManager)
                        ? AudioManager.RINGER_MODE_NORMAL
                        : AudioManager.RINGER_MODE_SILENT);
    }
    public static boolean isPhoneSilent(AudioManager audioManager) {
        return audioManager.getRingerMode()
                == AudioManager.RINGER_MODE_SILENT;
    }
}