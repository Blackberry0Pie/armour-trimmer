/*
 * Copyright (c) 2020, Truth Forger <https://github.com/Blackberry0Pie>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package bbp.trimmer;

import com.google.common.collect.ImmutableMap;
import net.runelite.api.ItemID;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.game.ItemManager;
import net.runelite.client.ui.overlay.WidgetItemOverlay;

import javax.inject.Inject;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Map;

public class ArmourTrimmerOverlay extends WidgetItemOverlay
{
	private final ItemManager itemManager;
	private final ArmourTrimmerConfig config;
	private static final Map<Integer, Integer[]> ARMOUR_REMAP = new ImmutableMap.Builder<Integer, Integer[]>().
			put(ItemID.BRONZE_FULL_HELM, new Integer[] {ItemID.BRONZE_FULL_HELM_T, ItemID.BRONZE_FULL_HELM_G}).
			put(ItemID.BRONZE_PLATEBODY, new Integer[] {ItemID.BRONZE_PLATEBODY_T, ItemID.BRONZE_PLATEBODY_G}).
			put(ItemID.BRONZE_PLATELEGS, new Integer[] {ItemID.BRONZE_PLATELEGS_T, ItemID.BRONZE_PLATELEGS_G}).
			put(ItemID.BRONZE_PLATESKIRT, new Integer[] {ItemID.BRONZE_PLATESKIRT_T, ItemID.BRONZE_PLATESKIRT_G}).
			put(ItemID.BRONZE_KITESHIELD, new Integer[] {ItemID.BRONZE_KITESHIELD_T, ItemID.BRONZE_KITESHIELD_G}).

			put(ItemID.IRON_FULL_HELM, new Integer[] {ItemID.IRON_FULL_HELM_T, ItemID.IRON_FULL_HELM_G}).
			put(ItemID.IRON_PLATEBODY, new Integer[] {ItemID.IRON_PLATEBODY_T, ItemID.IRON_PLATEBODY_G}).
			put(ItemID.IRON_PLATELEGS, new Integer[] {ItemID.IRON_PLATELEGS_T, ItemID.IRON_PLATELEGS_G}).
			put(ItemID.IRON_PLATESKIRT, new Integer[] {ItemID.IRON_PLATESKIRT_T, ItemID.IRON_PLATESKIRT_G}).
			put(ItemID.IRON_KITESHIELD, new Integer[] {ItemID.IRON_KITESHIELD_T, ItemID.IRON_KITESHIELD_G}).

			put(ItemID.STEEL_FULL_HELM, new Integer[] {ItemID.STEEL_FULL_HELM_T, ItemID.STEEL_FULL_HELM_G}).
			put(ItemID.STEEL_PLATEBODY, new Integer[] {ItemID.STEEL_PLATEBODY_T, ItemID.STEEL_PLATEBODY_G}).
			put(ItemID.STEEL_PLATELEGS, new Integer[] {ItemID.STEEL_PLATELEGS_T, ItemID.STEEL_PLATELEGS_G}).
			put(ItemID.STEEL_PLATESKIRT, new Integer[] {ItemID.STEEL_PLATESKIRT_T, ItemID.STEEL_PLATESKIRT_G}).
			put(ItemID.STEEL_KITESHIELD, new Integer[] {ItemID.STEEL_KITESHIELD_T, ItemID.STEEL_KITESHIELD_G}).

			put(ItemID.BLACK_FULL_HELM, new Integer[] {ItemID.BLACK_FULL_HELM_T, ItemID.BLACK_FULL_HELM_G}).
			put(ItemID.BLACK_PLATEBODY, new Integer[] {ItemID.BLACK_PLATEBODY_T, ItemID.BLACK_PLATEBODY_G}).
			put(ItemID.BLACK_PLATELEGS, new Integer[] {ItemID.BLACK_PLATELEGS_T, ItemID.BLACK_PLATELEGS_G}).
			put(ItemID.BLACK_PLATESKIRT, new Integer[] {ItemID.BLACK_PLATESKIRT_T, ItemID.BLACK_PLATESKIRT_G}).
			put(ItemID.BLACK_KITESHIELD, new Integer[] {ItemID.BLACK_KITESHIELD_T, ItemID.BLACK_KITESHIELD_G}).

			put(ItemID.MITHRIL_FULL_HELM, new Integer[] {ItemID.MITHRIL_FULL_HELM_T, ItemID.MITHRIL_FULL_HELM_G}).
			put(ItemID.MITHRIL_PLATEBODY, new Integer[] {ItemID.MITHRIL_PLATEBODY_T, ItemID.MITHRIL_PLATEBODY_G}).
			put(ItemID.MITHRIL_PLATELEGS, new Integer[] {ItemID.MITHRIL_PLATELEGS_T, ItemID.MITHRIL_PLATELEGS_G}).
			put(ItemID.MITHRIL_PLATESKIRT, new Integer[] {ItemID.MITHRIL_PLATESKIRT_T, ItemID.MITHRIL_PLATESKIRT_G}).
			put(ItemID.MITHRIL_KITESHIELD, new Integer[] {ItemID.MITHRIL_KITESHIELD_T, ItemID.MITHRIL_KITESHIELD_G}).

			put(ItemID.ADAMANT_FULL_HELM, new Integer[] {ItemID.ADAMANT_FULL_HELM_T, ItemID.ADAMANT_FULL_HELM_G}).
			put(ItemID.ADAMANT_PLATEBODY, new Integer[] {ItemID.ADAMANT_PLATEBODY_T, ItemID.ADAMANT_PLATEBODY_G}).
			put(ItemID.ADAMANT_PLATELEGS, new Integer[] {ItemID.ADAMANT_PLATELEGS_T, ItemID.ADAMANT_PLATELEGS_G}).
			put(ItemID.ADAMANT_PLATESKIRT, new Integer[] {ItemID.ADAMANT_PLATESKIRT_T, ItemID.ADAMANT_PLATESKIRT_G}).
			put(ItemID.ADAMANT_KITESHIELD, new Integer[] {ItemID.ADAMANT_KITESHIELD_T, ItemID.ADAMANT_KITESHIELD_G}).

			put(ItemID.RUNE_FULL_HELM, new Integer[] {ItemID.RUNE_FULL_HELM_T, ItemID.RUNE_FULL_HELM_G}).
			put(ItemID.RUNE_PLATEBODY, new Integer[] {ItemID.RUNE_PLATEBODY_T, ItemID.RUNE_PLATEBODY_G}).
			put(ItemID.RUNE_PLATELEGS, new Integer[] {ItemID.RUNE_PLATELEGS_T, ItemID.RUNE_PLATELEGS_G}).
			put(ItemID.RUNE_PLATESKIRT, new Integer[] {ItemID.RUNE_PLATESKIRT_T, ItemID.RUNE_PLATESKIRT_G}).
			put(ItemID.RUNE_KITESHIELD, new Integer[] {ItemID.RUNE_KITESHIELD_T, ItemID.RUNE_KITESHIELD_G}).

			put(ItemID.BLUE_WIZARD_HAT, new Integer[] {ItemID.BLUE_WIZARD_HAT_T, ItemID.BLUE_WIZARD_HAT_G}).
			put(ItemID.BLUE_WIZARD_ROBE, new Integer[] {ItemID.BLUE_WIZARD_ROBE_T, ItemID.BLUE_WIZARD_ROBE_G}).
			put(ItemID.BLUE_SKIRT, new Integer[] {ItemID.BLUE_SKIRT_T, ItemID.BLUE_SKIRT_G}).

			put(ItemID.WIZARD_HAT, new Integer[] {ItemID.BLACK_WIZARD_HAT_T, ItemID.BLACK_WIZARD_HAT_G}).
			put(ItemID.BLACK_ROBE, new Integer[] {ItemID.BLACK_WIZARD_ROBE_T, ItemID.BLACK_WIZARD_ROBE_G}).
			put(ItemID.BLACK_SKIRT, new Integer[] {ItemID.BLACK_SKIRT_T, ItemID.BLACK_SKIRT_G}).

			put(ItemID.LEATHER_BODY, new Integer[] {null, ItemID.LEATHER_BODY_G}).
			put(ItemID.LEATHER_CHAPS, new Integer[] {null, ItemID.LEATHER_CHAPS_G}).

			put(ItemID.STUDDED_BODY, new Integer[] {ItemID.STUDDED_BODY_T, ItemID.STUDDED_BODY_G}).
			put(ItemID.STUDDED_CHAPS, new Integer[] {ItemID.STUDDED_CHAPS_T, ItemID.STUDDED_CHAPS_G}).

			put(ItemID.GREEN_DHIDE_BODY, new Integer[] {ItemID.GREEN_DHIDE_BODY_T, ItemID.GREEN_DHIDE_BODY_G}).
			put(ItemID.GREEN_DHIDE_CHAPS, new Integer[] {ItemID.GREEN_DHIDE_CHAPS_T, ItemID.GREEN_DHIDE_CHAPS_G}).

			put(ItemID.BLUE_DHIDE_BODY, new Integer[] {ItemID.BLUE_DHIDE_BODY_T, ItemID.BLUE_DHIDE_BODY_G}).
			put(ItemID.BLUE_DHIDE_CHAPS, new Integer[] {ItemID.BLUE_DHIDE_CHAPS_T, ItemID.BLUE_DHIDE_CHAPS_G}).

			put(ItemID.RED_DHIDE_BODY, new Integer[] {ItemID.RED_DHIDE_BODY_T, ItemID.RED_DHIDE_BODY_G}).
			put(ItemID.RED_DHIDE_CHAPS, new Integer[] {ItemID.RED_DHIDE_CHAPS_T, ItemID.RED_DHIDE_CHAPS_G}).

			put(ItemID.BLACK_DHIDE_BODY, new Integer[] {ItemID.BLACK_DHIDE_BODY_T, ItemID.BLACK_DHIDE_BODY_G}).
			put(ItemID.BLACK_DHIDE_CHAPS, new Integer[] {ItemID.BLACK_DHIDE_CHAPS_T, ItemID.BLACK_DHIDE_CHAPS_G}).

			put(ItemID.MONKS_ROBE_TOP, new Integer[] {ItemID.MONKS_ROBE_TOP_T, ItemID.MONKS_ROBE_TOP_G}).
			put(ItemID.MONKS_ROBE, new Integer[] {ItemID.MONKS_ROBE_T, ItemID.MONKS_ROBE_G}).

			put(ItemID.CLIMBING_BOOTS, new Integer[] {null, ItemID.CLIMBING_BOOTS_G}).

			put(ItemID.WOODEN_SHIELD, new Integer[] {null, ItemID.WOODEN_SHIELD_G}).

			put(ItemID.FIRE_CAPE, new Integer[] {null, ItemID.INFERNAL_CAPE}).

			build();

	@Inject
	private ArmourTrimmerOverlay(ItemManager itemManager, ArmourTrimmerConfig config)
	{
		this.itemManager = itemManager;
		this.config = config;
		showOnEquipment();
		showOnInventory();
		showOnBank();
	}

	@Override
	public void renderItemOverlay(Graphics2D graphics, int itemId, WidgetItem itemWidget)
	{
		if (ARMOUR_REMAP.containsKey(itemId)) {
			Rectangle bounds = itemWidget.getCanvasBounds();
			final BufferedImage replacement = itemManager.getImage(ARMOUR_REMAP.get(itemId)[config.trimGold() || ARMOUR_REMAP.get(itemId)[0] == null ? 1 : 0]);
			graphics.drawImage(replacement, (int) bounds.getX(), (int) bounds.getY(), null);
		}
	}
}
