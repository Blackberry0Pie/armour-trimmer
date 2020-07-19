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
	private static final Map<Integer, Integer> ARMOUR_REMAP = new ImmutableMap.Builder<Integer, Integer>().
			put(ItemID.BRONZE_FULL_HELM,ItemID.BRONZE_FULL_HELM_G).
			put(ItemID.BRONZE_PLATEBODY,ItemID.BRONZE_PLATEBODY_G).
			put(ItemID.BRONZE_PLATELEGS,ItemID.BRONZE_PLATELEGS_G).
			put(ItemID.BRONZE_PLATESKIRT,ItemID.BRONZE_PLATESKIRT_G).
			put(ItemID.BRONZE_KITESHIELD,ItemID.BRONZE_KITESHIELD_G).

			put(ItemID.IRON_FULL_HELM,ItemID.IRON_FULL_HELM_G).
			put(ItemID.IRON_PLATEBODY,ItemID.IRON_PLATEBODY_G).
			put(ItemID.IRON_PLATELEGS,ItemID.IRON_PLATELEGS_G).
			put(ItemID.IRON_PLATESKIRT,ItemID.IRON_PLATESKIRT_G).
			put(ItemID.IRON_KITESHIELD,ItemID.IRON_KITESHIELD_G).

			put(ItemID.STEEL_FULL_HELM,ItemID.STEEL_FULL_HELM_G).
			put(ItemID.STEEL_PLATEBODY,ItemID.STEEL_PLATEBODY_G).
			put(ItemID.STEEL_PLATELEGS,ItemID.STEEL_PLATELEGS_G).
			put(ItemID.STEEL_PLATESKIRT,ItemID.STEEL_PLATESKIRT_G).
			put(ItemID.STEEL_KITESHIELD,ItemID.STEEL_KITESHIELD_G).

			put(ItemID.BLACK_FULL_HELM,ItemID.BLACK_FULL_HELM_G).
			put(ItemID.BLACK_PLATEBODY,ItemID.BLACK_PLATEBODY_G).
			put(ItemID.BLACK_PLATELEGS,ItemID.BLACK_PLATELEGS_G).
			put(ItemID.BLACK_PLATESKIRT,ItemID.BLACK_PLATESKIRT_G).
			put(ItemID.BLACK_KITESHIELD,ItemID.BLACK_KITESHIELD_G).

			put(ItemID.MITHRIL_FULL_HELM,ItemID.MITHRIL_FULL_HELM_G).
			put(ItemID.MITHRIL_PLATEBODY,ItemID.MITHRIL_PLATEBODY_G).
			put(ItemID.MITHRIL_PLATELEGS,ItemID.MITHRIL_PLATELEGS_G).
			put(ItemID.MITHRIL_PLATESKIRT,ItemID.MITHRIL_PLATESKIRT_G).
			put(ItemID.MITHRIL_KITESHIELD,ItemID.MITHRIL_KITESHIELD_G).

			put(ItemID.ADAMANT_FULL_HELM,ItemID.ADAMANT_FULL_HELM_G).
			put(ItemID.ADAMANT_PLATEBODY,ItemID.ADAMANT_PLATEBODY_G).
			put(ItemID.ADAMANT_PLATELEGS,ItemID.ADAMANT_PLATELEGS_G).
			put(ItemID.ADAMANT_PLATESKIRT,ItemID.ADAMANT_PLATESKIRT_G).
			put(ItemID.ADAMANT_KITESHIELD,ItemID.ADAMANT_KITESHIELD_G).

			put(ItemID.RUNE_FULL_HELM,ItemID.RUNE_FULL_HELM_G).
			put(ItemID.RUNE_PLATEBODY,ItemID.RUNE_PLATEBODY_G).
			put(ItemID.RUNE_PLATELEGS,ItemID.RUNE_PLATELEGS_G).
			put(ItemID.RUNE_PLATESKIRT,ItemID.RUNE_PLATESKIRT_G).
			put(ItemID.RUNE_KITESHIELD,ItemID.RUNE_KITESHIELD_G).

			put(ItemID.BLUE_WIZARD_HAT,ItemID.BLUE_WIZARD_HAT_G).
			put(ItemID.BLUE_WIZARD_ROBE,ItemID.BLUE_WIZARD_ROBE_G).
			put(ItemID.BLUE_SKIRT,ItemID.BLUE_SKIRT_G).

			put(ItemID.WIZARD_HAT,ItemID.BLACK_WIZARD_HAT_G).
			put(ItemID.BLACK_ROBE,ItemID.BLACK_WIZARD_ROBE_G).
			put(ItemID.BLACK_SKIRT,ItemID.BLACK_SKIRT_G).

			put(ItemID.LEATHER_BODY,ItemID.LEATHER_BODY_G).
			put(ItemID.LEATHER_CHAPS,ItemID.LEATHER_CHAPS_G).

			put(ItemID.STUDDED_BODY,ItemID.STUDDED_BODY_G).
			put(ItemID.STUDDED_CHAPS,ItemID.STUDDED_CHAPS_G).

			put(ItemID.GREEN_DHIDE_BODY,ItemID.GREEN_DHIDE_BODY_G).
			put(ItemID.GREEN_DHIDE_CHAPS,ItemID.GREEN_DHIDE_CHAPS_G).

			put(ItemID.BLUE_DHIDE_BODY,ItemID.BLUE_DHIDE_BODY_G).
			put(ItemID.BLUE_DHIDE_CHAPS,ItemID.BLUE_DHIDE_CHAPS_G).

			put(ItemID.RED_DHIDE_BODY,ItemID.RED_DHIDE_BODY_G).
			put(ItemID.RED_DHIDE_CHAPS,ItemID.RED_DHIDE_CHAPS_G).

			put(ItemID.BLACK_DHIDE_BODY,ItemID.BLACK_DHIDE_BODY_G).
			put(ItemID.BLACK_DHIDE_CHAPS,ItemID.BLACK_DHIDE_CHAPS_G).

			put(ItemID.CLIMBING_BOOTS,ItemID.CLIMBING_BOOTS_G).

			put(ItemID.WOODEN_SHIELD,ItemID.WOODEN_SHIELD_G).

			build();

	@Inject
	private ArmourTrimmerOverlay(ItemManager itemManager)
	{
		this.itemManager = itemManager;
		showOnEquipment();
		showOnInventory();
		showOnBank();
	}

	@Override
	public void renderItemOverlay(Graphics2D graphics, int itemId, WidgetItem itemWidget)
	{
		if (ARMOUR_REMAP.containsKey(itemId)) {
			Rectangle bounds = itemWidget.getCanvasBounds();
			final BufferedImage replacement = itemManager.getImage(ARMOUR_REMAP.get(itemId));
			graphics.drawImage(replacement, (int) bounds.getX(), (int) bounds.getY(), null);
		}
	}
}
