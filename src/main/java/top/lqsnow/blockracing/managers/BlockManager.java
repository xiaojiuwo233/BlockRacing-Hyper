package top.lqsnow.blockracing.managers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static top.lqsnow.blockracing.listeners.EventListener.blockAmount;
import static top.lqsnow.blockracing.listeners.EventListener.*;

public class BlockManager {
    // 设置方块库
    public static boolean blockAmountCheckout = false;
    public static int maxBlockAmount;
    public static String[] easyBlocks;
    public static String[] normalBlocks;
    public static String[] hardBlocks;
    public static String[] dyedBlocks;
    public static String[] endBlocks;
    public static String[] blocks;

    public static void init() {
        ArrayList<String> var = new ArrayList<>();
        Collections.addAll(var, easyBlocks);
        if (enableNormalBlock) Collections.addAll(var, normalBlocks);
        if (enableHardBlock) Collections.addAll(var, hardBlocks);
        if (enableDyedBlock) Collections.addAll(var, dyedBlocks);
        if (enableEndBlock) Collections.addAll(var, endBlocks);
        if (blockAmount > var.size()) {
            blockAmountCheckout = false;
            maxBlockAmount = var.size();
            return;
        } else {
            blockAmountCheckout = true;
        }
        blocks = var.toArray(new String[0]);
    }

    public static List<String> getAllBlock() {
        List<String> allBlock = new ArrayList<>();
        allBlock.addAll(Arrays.asList(easyBlocks));
        allBlock.addAll(Arrays.asList(normalBlocks));
        allBlock.addAll(Arrays.asList(hardBlocks));
        allBlock.addAll(Arrays.asList(dyedBlocks));
        allBlock.addAll(Arrays.asList(endBlocks));

        return allBlock;
    }
}