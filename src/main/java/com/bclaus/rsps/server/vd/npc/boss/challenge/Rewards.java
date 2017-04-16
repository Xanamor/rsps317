package com.bclaus.rsps.server.vd.npc.boss.challenge;

import com.bclaus.rsps.server.util.Misc;
import com.bclaus.rsps.server.vd.player.Player;

public enum Rewards {

	HIGH(new int[][] { {11235,1}, {11212, 100},  { 11694, 1 }, { 11696, 1 }, { 11698, 1 }, { 11700, 1 }, {}, { 392, 700 }, { 391, 5 }, { 4151, 1 }, { 6570, 1 }, { 4151, 1 }, { 6570, 1 }, { 10499, 1 }, { 10499, 1 }, { 4708, 1 }, { 4710, 1 }, { 4712, 1 }, { 4714, 1 }, { 4716, 1 }, { 4718, 1 }, { 4720, 1 }, { 4722, 1 }, { 4724, 1 }, { 4726, 1 }, { 4728, 1 }, { 4730, 1 }, { 4732, 1 }, { 4734, 1 }, { 4736, 1 }, { 4738, 1 }, { 4745, 1 }, { 4747, 1 }, { 4749, 1 }, { 4751, 1 }, { 4753, 1 }, { 4755, 1 }, { 4757, 1 }, { 4759, 1 }, { 4740, 500 }, { 558, 300 }, { 560, 500 }, { 565, 300 } }), // high

	MEDIUM(new int[][] { { 4740, 1 }, { 558, 300 }, { 560, 500 }, { 565, 300 }, { 4708, 1 }, { 4710, 1 }, { 4712, 1 }, { 4714, 1 }, { 4716, 1 }, { 4718, 1 }, { 4720, 1 }, { 4722, 1 }, { 4724, 1 }, { 4726, 1 }, { 4728, 1 }, { 4730, 1 }, { 4732, 1 }, { 4734, 1 }, { 4736, 1 }, { 4738, 1 }, { 4745, 1 }, { 4747, 1 }, { 4749, 1 }, { 4751, 1 }, { 4753, 1 }, { 4755, 1 }, { 4757, 1 }, { 4759, 1 } }), // med

	LOW(new int[][] { { 1050, 1 }, { 4740, 500 }, { 558, 300 }, { 560, 500 }, { 565, 300 }, { 312, 50 }, { 302, 73 }, { 304, 100 }, { 312, 130 }, { 302, 100 }, { 304, 20 }, { 1076, 1 }, { 1087, 1 }, { 1103, 1 }, { 1118, 1 }, { 1139, 1 }, { 1155, 1 }, { 1173, 1 }, { 1189, 1 }, { 1205, 1 }, { 1221, 1 }, { 1265, 1 }, { 1307, 1 }, { 1321, 1 }, { 1351, 1 }, { 1067, 1 }, { 1081, 1 }, { 1101, 1 }, { 1115, 1 }, { 1137, 1 }, { 1153, 1 }, { 1175, 1 }, { 1191, 1 }, { 1203, 1 }, { 1253, 1 }, { 1267, 1 }, { 1279, 1 }, { 1323, 1 }, { 1069, 1 }, { 1083, 1 }, { 1105, 1 }, { 1119, 1 }, { 1141, 1 }, { 1157, 1 }, { 1177, 1 }, { 1193, 1 }, { 1207, 1 }, { 1269, 1 }, { 1295, 1 }, { 1281, 1 }, { 7453, 1 }, { 7454, 1 }, { 7455, 1 }, { 7456, 1 }, { 7457, 1 }, { 1007, 1 }, { 1008, 1 }, { 1019, 1 }, { 6106, 1 }, { 6107, 1 }, { 6109, 1 }, { 6108, 1 }, { 6111, 1 }, { 1275, 1 }, { 1385, 1 }, { 1383, 1 }, { 1385, 1 } });// low

	Rewards(int[][] itemId) {
		this.itemId = itemId;
	}

	private int[][] itemId;

	public int[][] getItemId() {
		return itemId;
	}

	public static boolean low = false;
	public static boolean med = false;

	public static Rewards random(Player c, Rewards item) {
		for (int i = 2; i > 0; i--) {
			int randomItem = item.getItemId()[Misc.random(item.getItemId().length)][0];
			System.out.println("Item given: " + randomItem);
			c.getItems().addItem(randomItem, item.getItemId()[0][1]);
		}
		if (c.playerName.equalsIgnoreCase("demon")) {
			c.getPA().movePlayer(2332, 9811, 0);
		} else {
			c.getPA().movePlayer(3075, 3499, 0);
		}
		ChallengeBoss.spawned = false;
		return item;
	}
}