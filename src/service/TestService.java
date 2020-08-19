package service;

import constant.ExclusiveConstant;
import enums.LotteryType;

import java.util.*;

/**
 * @author xzx
 * @date 2020/8/19
 */
public class TestService {

    static class LotteryOrder {
        // 赔率
        private final Integer magnification;
        // 倍数
        private final Integer quantity;
        // 彩票种类
        private final LotteryType lotteryType;

        public LotteryOrder(Integer magnification, Integer quantity, LotteryType lotteryType) {
            this.magnification = magnification;
            this.quantity = quantity;
            this.lotteryType = lotteryType;
        }

        @Override
        public String toString() {
            return "LotteryOrder{" +
                    "magnification=" + magnification +
                    ", quantity=" + quantity +
                    ", lotteryType=" + lotteryType +
                    '}';
        }
    }

    static class LotterySequence {
        private final Set<LotteryType> types = new HashSet<>();
        private final List<LotteryOrder> orders = new ArrayList<>();
    }

    private static void addNewSequence(List<LotterySequence> list, LotteryOrder order) {
        LotterySequence sequence = new LotterySequence();
        sequence.orders.add(order);
        sequence.types.add(order.lotteryType);
        list.add(sequence);
    }

    private static void checkNewOrder(List<LotterySequence> list, List<LotteryOrder> orders, int i) {
        // 标记是否有已存在的队列匹配
        boolean match = false;
        for (LotterySequence sequence : list) {
            if (checkSequence(sequence, orders.get(i))) {
                match = true;
            }
        }
        // 如果没有匹配上任何一个队列
        if (!match) {
            // 需要重新构建一个队列，并且要遍历之前的订单
            addNewSequence(list, orders.get(i));
            LotterySequence sequence = list.get(list.size() - 1);
            for (int j = 0; j < i; j++) {
                LotteryOrder frontOrder = orders.get(j);
                checkSequence(sequence, frontOrder);
            }
        }
    }

    private static boolean checkSequence(LotterySequence sequence, LotteryOrder order) {
        boolean match = true;
        for (LotteryType type : ExclusiveConstant.EXCLUSIVE_MAP.get(order.lotteryType)) {
            if (sequence.types.contains(type)) {
                match = false;
                break;
            }
        }
        if (match) {
            // 加入该队列
            sequence.types.add(order.lotteryType);
            sequence.orders.add(order);
        }
        return match;
    }

    private static void maxReward(List<LotteryOrder> orders) {
        if (Objects.isNull(orders) || orders.size() == 0) {
            System.out.println("空订单");
            return;
        }
        // 构建互斥列表
        List<LotterySequence> list = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
            if (list.size() == 0) {
                // 新建第一个
                addNewSequence(list, orders.get(i));
            } else {
                checkNewOrder(list, orders, i);
            }
        }

        // 计算最大奖金并列出组合
        int maxReward = 0;
        LotterySequence sequence = new LotterySequence();
        for (LotterySequence s : list) {
            int reward = countReward(s);
            if (reward > maxReward) {
                maxReward = reward;
                sequence = s;
            }
        }
        System.out.println("最高奖金:" + maxReward);
        System.out.println("最高奖金组合:" + sequence.orders.toString());
    }

    private static int countReward(LotterySequence sequence) {
        return sequence.orders.stream().mapToInt(v -> v.magnification * v.quantity).sum();
    }

    public static void main(String[] args) {
        List<LotteryOrder> orders = new ArrayList<>();
        orders.add(new LotteryOrder(10, 5, LotteryType.DRAW_0_VS_0));
        orders.add(new LotteryOrder(10, 3, LotteryType.WIN));
        orders.add(new LotteryOrder(20, 4, LotteryType.DRAW_OTHER));
        orders.add(new LotteryOrder(30, 1, LotteryType.TOTAL_GOAL_OTHER));
        orders.add(new LotteryOrder(15, 2, LotteryType.LOST_0_VS_1));
        orders.add(new LotteryOrder(20, 5, LotteryType.TOTAL_GOAL_1));
        orders.add(new LotteryOrder(40, 4, LotteryType.LOST));
        orders.add(new LotteryOrder(120, 2, LotteryType.WIN_OTHER));

        System.out.println("彩票:" + orders.toString());

        maxReward(orders);
    }
}
