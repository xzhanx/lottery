package constant;

import enums.LotteryType;

import java.util.*;

/**
 * @author xzx
 * @date 2020/8/13
 */
public class ExclusiveConstant {

    public static final Map<LotteryType, Set<LotteryType>> EXCLUSIVE_MAP = new HashMap<>();

    static {
        EXCLUSIVE_MAP.put(LotteryType.WIN, new HashSet<>(Arrays.asList(LotteryType.DRAW,
                LotteryType.LOST,
                LotteryType.DRAW_0_VS_0,
                LotteryType.DRAW_OTHER,
                LotteryType.LOST_0_VS_1,
                LotteryType.LOST_OTHER,
                LotteryType.TOTAL_GOAL_0
                )));

        EXCLUSIVE_MAP.put(LotteryType.DRAW, new HashSet<>(Arrays.asList(LotteryType.WIN,
                LotteryType.LOST,
                LotteryType.WIN_1_VS_0,
                LotteryType.WIN_OTHER,
                LotteryType.LOST_0_VS_1,
                LotteryType.LOST_OTHER,
                LotteryType.TOTAL_GOAL_1
        )));

        EXCLUSIVE_MAP.put(LotteryType.LOST, new HashSet<>(Arrays.asList(LotteryType.WIN,
                LotteryType.DRAW,
                LotteryType.WIN_1_VS_0,
                LotteryType.WIN_OTHER,
                LotteryType.DRAW_0_VS_0,
                LotteryType.DRAW_OTHER,
                LotteryType.TOTAL_GOAL_0
        )));

        EXCLUSIVE_MAP.put(LotteryType.WIN_1_VS_0, new HashSet<>(Arrays.asList(LotteryType.DRAW,
                LotteryType.LOST,
                LotteryType.WIN_OTHER,
                LotteryType.DRAW_0_VS_0,
                LotteryType.DRAW_OTHER,
                LotteryType.LOST_0_VS_1,
                LotteryType.LOST_OTHER,
                LotteryType.TOTAL_GOAL_0,
                LotteryType.TOTAL_GOAL_2,
                LotteryType.TOTAL_GOAL_OTHER
        )));

        EXCLUSIVE_MAP.put(LotteryType.WIN_OTHER, new HashSet<>(Arrays.asList(LotteryType.DRAW,
                LotteryType.LOST,
                LotteryType.WIN_1_VS_0,
                LotteryType.DRAW_0_VS_0,
                LotteryType.DRAW_OTHER,
                LotteryType.LOST_0_VS_1,
                LotteryType.LOST_OTHER,
                LotteryType.TOTAL_GOAL_0,
                LotteryType.TOTAL_GOAL_1
        )));

        EXCLUSIVE_MAP.put(LotteryType.DRAW_0_VS_0, new HashSet<>(Arrays.asList(LotteryType.WIN,
                LotteryType.LOST,
                LotteryType.WIN_1_VS_0,
                LotteryType.WIN_OTHER,
                LotteryType.DRAW_OTHER,
                LotteryType.LOST_0_VS_1,
                LotteryType.LOST_OTHER,
                LotteryType.TOTAL_GOAL_1,
                LotteryType.TOTAL_GOAL_2,
                LotteryType.TOTAL_GOAL_OTHER
        )));

        EXCLUSIVE_MAP.put(LotteryType.DRAW_OTHER, new HashSet<>(Arrays.asList(LotteryType.WIN,
                LotteryType.LOST,
                LotteryType.WIN_1_VS_0,
                LotteryType.WIN_OTHER,
                LotteryType.DRAW_0_VS_0,
                LotteryType.LOST_0_VS_1,
                LotteryType.LOST_OTHER,
                LotteryType.TOTAL_GOAL_0,
                LotteryType.TOTAL_GOAL_1
        )));

        EXCLUSIVE_MAP.put(LotteryType.LOST_0_VS_1, new HashSet<>(Arrays.asList(LotteryType.WIN,
                LotteryType.DRAW,
                LotteryType.WIN_1_VS_0,
                LotteryType.WIN_OTHER,
                LotteryType.DRAW_0_VS_0,
                LotteryType.DRAW_OTHER,
                LotteryType.LOST_OTHER,
                LotteryType.TOTAL_GOAL_0,
                LotteryType.TOTAL_GOAL_2,
                LotteryType.TOTAL_GOAL_OTHER
        )));

        EXCLUSIVE_MAP.put(LotteryType.LOST_OTHER, new HashSet<>(Arrays.asList(LotteryType.WIN,
                LotteryType.DRAW,
                LotteryType.WIN_1_VS_0,
                LotteryType.WIN_OTHER,
                LotteryType.DRAW_0_VS_0,
                LotteryType.DRAW_OTHER,
                LotteryType.LOST_0_VS_1,
                LotteryType.TOTAL_GOAL_0,
                LotteryType.TOTAL_GOAL_1
        )));

        EXCLUSIVE_MAP.put(LotteryType.TOTAL_GOAL_0, new HashSet<>(Arrays.asList(LotteryType.WIN,
                LotteryType.LOST,
                LotteryType.WIN_1_VS_0,
                LotteryType.WIN_OTHER,
                LotteryType.DRAW_OTHER,
                LotteryType.LOST_0_VS_1,
                LotteryType.LOST_OTHER,
                LotteryType.TOTAL_GOAL_1,
                LotteryType.TOTAL_GOAL_2,
                LotteryType.TOTAL_GOAL_OTHER
        )));

        EXCLUSIVE_MAP.put(LotteryType.TOTAL_GOAL_1, new HashSet<>(Arrays.asList(LotteryType.DRAW,
                LotteryType.WIN_OTHER,
                LotteryType.DRAW_0_VS_0,
                LotteryType.DRAW_OTHER,
                LotteryType.LOST_OTHER,
                LotteryType.TOTAL_GOAL_0,
                LotteryType.TOTAL_GOAL_2,
                LotteryType.TOTAL_GOAL_OTHER
        )));

        EXCLUSIVE_MAP.put(LotteryType.TOTAL_GOAL_2, new HashSet<>(Arrays.asList(
                LotteryType.WIN_1_VS_0,
                LotteryType.DRAW_0_VS_0,
                LotteryType.LOST_0_VS_1,
                LotteryType.TOTAL_GOAL_0,
                LotteryType.TOTAL_GOAL_1,
                LotteryType.TOTAL_GOAL_OTHER
        )));

        EXCLUSIVE_MAP.put(LotteryType.TOTAL_GOAL_OTHER, new HashSet<>(Arrays.asList(
                LotteryType.WIN_1_VS_0,
                LotteryType.DRAW_0_VS_0,
                LotteryType.LOST_0_VS_1,
                LotteryType.TOTAL_GOAL_0,
                LotteryType.TOTAL_GOAL_1,
                LotteryType.TOTAL_GOAL_2
        )));
    }
}
