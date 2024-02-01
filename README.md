# 方块竞速BlockRacing 极速版

## 原作者已收录该模式 请前往[作者原仓库](https://github.com/LQSnow/BlockRacing)查看新版本！
### 注意：以下内容已过时，仅供留念，请前往原作者仓库获取新版插件进行游玩！
### 如果你需要基岩版支持，请查看[这里](https://github.com/xiaojiuwo233/BlockRacingBE)
### 如果你需要为游戏增加新内容，请期待我后续进行开发的数据包

---
版本：Java 1.20.1

原作者 ： [LQSnow/BlockRacing](https://github.com/LQSnow/BlockRacing)

基于原插件V2.1版本

详细基础功能请查看原仓库

本版本基于原版增加了一些功能，使游玩更加顺畅

注意：本插件均为根据自己想法修改，便于与群友游玩 可能一些修改并不适合每个人

欢迎提交issue和pr 由于本人并不会写java 修改内容有限 有的建议可能无法实现

# 修改内容
1.将插件版本升级为1.20.1 支持新方块 locate新群系

2.每局roll次数更改为3次 并且不仅限于简单方块 来源：[BlockyDeer/BlockRacingPlus](https://github.com/BlockyDeer/BlockRacingPlus)

3.将菜单打开方式改为 潜行+空手右键 便于适配**基岩版**玩家游玩

4.~~取消随机tp首次免费（退出重进可以无限卡bug免费）取而代之为开局给予初始积分 初始积分取决于游玩总人数的多少~~ 作者已修复该BUG 已还原原有逻辑

5.游戏过程中增加 急迫5 夜视 效果 （开始游戏后触发）

6.收集方块获取积分x3 收集一个方块可以获得3积分

7.游戏开始后 给予每个玩家 铁镐（精准采集） 熟牛排x64  损坏的鞘翅  经验修补的附魔书 道具加快游戏进度

8.推荐使用该[数据包](https://www.bilibili.com/video/BV1wj41117ke/) 降低染色方块难度

# 自动加载数据包

在服务器根目录创建文件夹 `datapacks` 将数据包放入

更改服务器启动文件（start.bat）：
  ```
:s
rd /s /q world
rd /s /q world_nether
rd /s /q world_the_end
xcopy /E/C/I datapacks world\datapacks
java -jar paper-1.20.1.jar --nogui
goto s
```

# 更新日志

## 2024.2.2 
整理归档仓库

## 2023.9.24 V1.2.2
1.修复方块数量bug

2.修复退出重进引起的bug

## 2023.9.21 V1.2 
同步更新至原作者2.1版本

# 版权说明

该项目签署 [**GNU Affero General Public License v3.0**](https://github.com/LQSnow/BlockRacing/blob/main/LICENSE) 授权许可

The project is licensed under the [**GNU Affero General Public License v3.0**](https://github.com/LQSnow/BlockRacing/blob/main/LICENSE)
