package top.lqsnow.blockracing.managers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;


import java.util.ArrayList;
import java.util.Collections;

import static top.lqsnow.blockracing.listeners.EventListener.blockAmount;
import static top.lqsnow.blockracing.listeners.EventListener.*;
import static top.lqsnow.blockracing.managers.BlockManager.*;
import static top.lqsnow.blockracing.managers.GameManager.*;
import static top.lqsnow.blockracing.managers.GameTick.blueCompleteAmount;
import static top.lqsnow.blockracing.managers.GameTick.redCompleteAmount;

public class ScoreboardManager {
    public static Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
    public static Team red = scoreboard.registerNewTeam("red");
    public static Team blue = scoreboard.registerNewTeam("blue");
    public static Objective sidebar;
    public static int redTeamScore;
    public static int blueTeamScore;
    static ArrayList<String> easyBlock = new ArrayList<>();
    static ArrayList<String> normalBlock = new ArrayList<>();
    static ArrayList<String> hardBlock = new ArrayList<>();
    static ArrayList<String> dyedBlock = new ArrayList<>();
    static ArrayList<String> endBlock = new ArrayList<>();

    // 服务器第一次启动时的初始设置
    public static void createScoreboard() {
        red.setDisplayName(ChatColor.RED + "红队");
        red.setColor(ChatColor.RED);
        red.setPrefix(ChatColor.RED + "[红队]");
        red.addEntry("redPlayer");
        blue.setDisplayName(ChatColor.BLUE + "蓝队");
        blue.setColor(ChatColor.BLUE);
        blue.setPrefix(ChatColor.BLUE + "[蓝队]");
        blue.addEntry("bluePlayer");

        sidebar = scoreboard.registerNewObjective("sidebar", "dummy");
        sidebar.setDisplaySlot(DisplaySlot.SIDEBAR);
        for (int i = 1; i <= 15; i++) {
            Team team = scoreboard.registerNewTeam("SLOT_" + i);
            team.addEntry(genEntry(i));
        }
    }

    // 游戏开始前准备阶段的记分板设置
    public static void setPreScoreboard() {
        setTitle("&b方块竞速 &c极速模式");
        setSlot(9, ChatColor.GREEN + "潜行+右键打开菜单");
        setSlot(8, ChatColor.GREEN + "手机玩家请使用 潜行空手点地 打开菜单");
        setSlot(7, ChatColor.RED + "极速模式启用中！");
        setSlot(6, ChatColor.YELLOW + "当前模式：" + (extremeMode ? "极限竞速模式" : "普通模式"));
        setSlot(5, ChatColor.YELLOW + "目标方块数量：" + blockAmount);
        setSlot(4, ChatColor.YELLOW + "目标方块库：简单方块" + (enableNormalBlock ? "+中等方块" : "") + (enableHardBlock ? "+困难方块" : "") + (enableDyedBlock ? "+染色方块" : "") + (enableEndBlock ? "+末地方块" : ""));
        setSlot(2, "&e&lModified by xjw233");
        setSlot(1, "&ewww.github.com/LQSnow");
    }

    public static void setGameScoreboard() {
        Collections.addAll(easyBlock, easyBlocks);
        Collections.addAll(normalBlock, normalBlocks);
        Collections.addAll(hardBlock, hardBlocks);
        Collections.addAll(dyedBlock, dyedBlocks);
        Collections.addAll(endBlock, endBlocks);

        if (redCurrentBlocks.size() >= 1) {
            setSlot(12, setDifficultyDisplay(redCurrentBlocks.get(0)));
            setSlot(11, "");
            setSlot(10, "");
            setSlot(9, "");
        }
        if (redCurrentBlocks.size() >= 2) {
            setSlot(11, setDifficultyDisplay(redCurrentBlocks.get(1)));
        }
        if (redCurrentBlocks.size() >= 3) {
            setSlot(10, setDifficultyDisplay(redCurrentBlocks.get(2)));
        }
        if (redCurrentBlocks.size() >= 4) {
            setSlot(9, setDifficultyDisplay(redCurrentBlocks.get(3)));
        }
        if (blueCurrentBlocks.size() >= 1) {
            setSlot(6, setDifficultyDisplay(blueCurrentBlocks.get(0)));
            setSlot(5, "");
            setSlot(4, "");
            setSlot(3, "");
        }
        if (blueCurrentBlocks.size() >= 2) {
            setSlot(5, setDifficultyDisplay(blueCurrentBlocks.get(1)));
        }
        if (blueCurrentBlocks.size() >= 3) {
            setSlot(4, setDifficultyDisplay(blueCurrentBlocks.get(2)));
        }
        if (blueCurrentBlocks.size() >= 4) {
            setSlot(3, setDifficultyDisplay(blueCurrentBlocks.get(3)));
        }

        if (extremeMode) setSlot(15, ChatColor.YELLOW + "当前游戏模式为极限竞速模式！");
        setSlot(14, ChatColor.GREEN + "极速模式启用中！3倍积分！ 特殊buff！");
        setSlot(13, "&c红队：&e" + redTeamScore + "分" + "\u00a7b  (" + redCompleteAmount + "/" + blockAmount + ")");
        setSlot(8, "-------------------");
        setSlot(7, "&9蓝队：&e" + blueTeamScore + "分" + "\u00a7b  (" + blueCompleteAmount + "/" + blockAmount + ")");
        setSlot(2, "&eModified by xjw233");
        setSlot(1, "&e&lMade by LQ_Snow");
    }

    public static void update() {
        if (!gameStart) setPreScoreboard();
        else setGameScoreboard();
    }
    public static void roll() {

    }


    // 设置玩家记分板
    public static void setPlayerScoreboard(Player p) {
        p.setScoreboard(scoreboard);
    }

    private static String setDifficultyDisplay(String block) {
        try {
            if (easyBlock.contains(block)) {
                return ChatColor.GREEN + "简单 " + "| " + TranslationManager.getValue(block);
            } else if (normalBlock.contains(block)) {
                return ChatColor.YELLOW + "中等 " + "| " + TranslationManager.getValue(block);
            } else if (hardBlock.contains(block)) {
                return ChatColor.RED + "困难 " + "| " + TranslationManager.getValue(block);
            } else if (dyedBlock.contains(block)) {
                return ChatColor.LIGHT_PURPLE + "染色 " + "| " + TranslationManager.getValue(block);
            } else if (endBlock.contains(block)) {
                return ChatColor.YELLOW + "末地 " + "| " + TranslationManager.getValue(block);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * https://github.com/Andy-K-Sparklight/PluginDiaryCode/blob/master/RarityCommons/src/main/java/rarityeg/commons/ScoreHelper.java
     * Help build up a scoreboard.
     * Considering RarityCommons isn't designed for Paper only,
     * we won't make migrations before Bukkit and Spigot support Kyori Powered Adventure.
     *
     * @author crisdev333
     * @author RarityEG
     * @see net.kyori.adventure.text.Component
     */
    private static String genEntry(int slot) {
        return ChatColor.values()[slot].toString();
    }

    private static void setTitle(String title) {
        title = ChatColor.translateAlternateColorCodes('&', title);
        sidebar.setDisplayName(title.length() > 32 ? title.substring(0, 32) : title);
    }

    private static void setSlot(int slot, String text) {
        Team team = scoreboard.getTeam("SLOT_" + slot);
        String entry = genEntry(slot);
        if (!scoreboard.getEntries().contains(entry)) {
            sidebar.getScore(entry).setScore(slot);
        }

        text = ChatColor.translateAlternateColorCodes('&', text);
        String pre = getFirstSplit(text);
        String suf = getFirstSplit(ChatColor.getLastColors(pre) + getSecondSplit(text));
        if (team == null) {
            return;
        }
        team.setPrefix(pre);
        team.setSuffix(suf);
    }

    private static String getFirstSplit(String s) {
        return s.length() > 16 ? s.substring(0, 16) : s;
    }

    private static String getSecondSplit(String s) {
        if (s.length() > 32) {
            s = s.substring(0, 32);
        }
        return s.length() > 16 ? s.substring(16) : "";
    }
}
