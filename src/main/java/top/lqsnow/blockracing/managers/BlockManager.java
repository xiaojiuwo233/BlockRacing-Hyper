package top.lqsnow.blockracing.managers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static top.lqsnow.blockracing.listeners.BasicEventListener.blockAmount;
import static top.lqsnow.blockracing.listeners.InventoryEventListener.*;

public class BlockManager {
    // 设置方块库
    public static boolean blockAmountCheckout = false;
    public static int maxBlockAmount;
    public static String[] easyBlocks, normalBlocks, hardBlocks, dyedBlocks, endBlocks, blocks;

    public static void init() {
        List<String> var = new ArrayList<>(Arrays.asList(easyBlocks));
        if (enableNormalBlock) var.addAll(Arrays.asList(normalBlocks));
        if (enableHardBlock) var.addAll(Arrays.asList(hardBlocks));
        if (enableDyedBlock) var.addAll(Arrays.asList(dyedBlocks));
        if (enableEndBlock) var.addAll(Arrays.asList(endBlocks));
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
