package me.qrashi.plugins.bedwars.Inventories;

import me.qrashi.plugins.bedwars.Utils.MessageCreator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class InventoryHandeler implements Listener {

    //main Inventory handeler
    private void handleClick(char command, String arguments, Player player) {
        switch (command) {
            case 's':
                switch (arguments) {
                    case "main":
                        InvOpener.openDelay(player, MainShop.shop());
                        break;
                    case "bau":
                        InvOpener.openDelay(player, SideBranchesShop.Baumaterialien());
                        break;
                    case "rüstung":
                        InvOpener.openDelay(player, SideBranchesShop.Rüstung());
                        break;
                    case "werkzeuge":
                        InvOpener.openDelay(player, SideBranchesShop.Werkzeug());
                        break;
                    case "waffen":
                        InvOpener.openDelay(player, SideBranchesShop.Waffen());
                        break;
                    case "bögen":
                        InvOpener.openDelay(player, SideBranchesShop.Boegen());
                        break;
                }
            case 'o':
                switch (arguments) {
                    case "setup":
                        InvOpener.openDelay(player, SetupInventory.mainInv());
                        break;
                }
        }
    }

    //static util methods

    public static Inventory createInventory(String name, int size) {
        Inventory inv = Bukkit.createInventory(null, size, MessageCreator.t(name));
        IntStream.range(0, 45).forEachOrdered(n -> inv.setItem(n, getNothing()));
        return inv;
    }
    public static Inventory createInventory(String name) {
        Inventory inv = Bukkit.createInventory(null, 45, MessageCreator.t(name));
        IntStream.range(0, 45).forEachOrdered(n -> inv.setItem(n, getNothing()));
        return inv;
    }

    public static ItemStack createStack(Material material, String name, List<String> lore, String command, boolean enchanted) {
        ItemStack stack = new ItemStack(material, 1);
        ItemMeta stack_meta = stack.getItemMeta();
        assert stack_meta != null;
        stack_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        List<String> newlore = new java.util.ArrayList<>(Collections.emptyList());
        for(String i: lore){
            newlore.add(ChatColor.translateAlternateColorCodes('&', i));
        }
        newlore.add(ChatColor.translateAlternateColorCodes('&', "&0&o" + command));
        newlore.add(ChatColor.translateAlternateColorCodes('&', "&0&oInvasionBW"));
        stack_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_POTION_EFFECTS);
        stack_meta.setLore(newlore);
        stack.setItemMeta(stack_meta);
        if(enchanted){
            stack.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
        }
        return stack;
    }
    public static ItemStack createStack(Material material, String name, List<String> lore, String command) {
        ItemStack stack = new ItemStack(material, 1);
        ItemMeta stack_meta = stack.getItemMeta();
        assert stack_meta != null;
        stack_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        List<String> newlore = new java.util.ArrayList<>(Collections.emptyList());
        for(String i: lore){
            newlore.add(ChatColor.translateAlternateColorCodes('&', i));
        }
        newlore.add(ChatColor.translateAlternateColorCodes('&', "&0&o" + command));
        newlore.add(ChatColor.translateAlternateColorCodes('&', "&0&oInvasionBW"));
        stack_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_POTION_EFFECTS);
        stack_meta.setLore(newlore);
        stack.setItemMeta(stack_meta);
        return stack;
    }
    public static ItemStack createStack(Material material, String name, List<String> lore, String command, int amount) {
        ItemStack stack = new ItemStack(material, amount);
        ItemMeta stack_meta = stack.getItemMeta();
        assert stack_meta != null;
        stack_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        List<String> newlore = new java.util.ArrayList<>(Collections.emptyList());
        for(String i: lore){
            newlore.add(ChatColor.translateAlternateColorCodes('&', i));
        }
        newlore.add(ChatColor.translateAlternateColorCodes('&', "&0&o" + command));
        newlore.add(ChatColor.translateAlternateColorCodes('&', "&0&oInvasionBW"));
        stack_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_POTION_EFFECTS);
        stack_meta.setLore(newlore);
        stack.setItemMeta(stack_meta);
        return stack;
    }
    public static ItemStack createStack(Material material, String name, List<String> lore) {
        ItemStack stack = new ItemStack(material, 1);
        ItemMeta stack_meta = stack.getItemMeta();
        assert stack_meta != null;
        stack_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        List<String> newlore = new java.util.ArrayList<>(Collections.emptyList());
        for(String i: lore){
            newlore.add(ChatColor.translateAlternateColorCodes('&', i));
        }
        newlore.add(ChatColor.translateAlternateColorCodes('&', "&0&oInvasionBW"));
        stack_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_POTION_EFFECTS);
        stack_meta.setLore(newlore);
        stack.setItemMeta(stack_meta);
        return stack;
    }
    public static ItemStack getNothing() {
        ItemStack nothing = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta nothing_meta =  nothing.getItemMeta();
        assert nothing_meta != null;
        nothing_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', " "));
        nothing_meta.setLore(Collections.singletonList(ChatColor.translateAlternateColorCodes('&', "&0&oInvasionBW")));
        nothing.setItemMeta(nothing_meta);
        return nothing;
    }

    //actual handlers

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        ItemStack clicked = event.getCurrentItem();
        if (clicked != null) {
            if (clicked.getType() != Material.AIR) {
                if (clicked.hasItemMeta()) {
                    ItemMeta meta = clicked.getItemMeta();
                    if (meta != null) {
                        if (meta.hasLore()) {
                            List lore = meta.getLore();
                            if (lore != null) {
                                if (lore.size() > 0) {

                                    if (ChatColor.stripColor((String) lore.get(lore.size() - 1)).equals("InvasionBW")) {
                                        event.setCancelled(true);
                                    }
                                    if (lore.size() > 1) {
                                        String commandraw = ChatColor.stripColor((String) lore.get(lore.size() - 2));
                                        HumanEntity player = event.getWhoClicked();
                                        Player playerP = Bukkit.getPlayer(player.getName());
                                        if (playerP != null) {
                                            playerP.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1, 2);
                                        }
                                        if (commandraw.length() > 0) {
                                            Character command = commandraw.charAt(0);
                                            StringBuilder arg = new StringBuilder();
                                            IntStream.range(2, commandraw.length() - 1).forEachOrdered(n -> arg.append(commandraw.charAt(n)));
                                            //Bukkit.broadcastMessage("Command: " + command + " Action: " + arg);
                                            String args = arg.toString();
                                            handleClick(command, args, playerP);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event) {
        ItemStack clicked = event.getCursor();
        if (clicked != null) {
            if (clicked.getType() != Material.AIR) {
                if (clicked.hasItemMeta()) {
                    ItemMeta meta = clicked.getItemMeta();
                    if (meta != null) {
                        if (meta.hasLore()) {
                            List lore = meta.getLore();
                            if (lore != null) {
                                if (lore.size() > 0) {

                                    if (ChatColor.stripColor((String) lore.get(lore.size() - 1)).equals("InvasionBW")) {
                                        event.setCancelled(true);
                                    }
                                    if (lore.size() > 1) {
                                        String commandraw = ChatColor.stripColor((String) lore.get(lore.size() - 2));
                                        HumanEntity player = event.getWhoClicked();
                                        Player playerP = Bukkit.getPlayer(player.getName());
                                        if (playerP != null) {
                                            playerP.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1, 2);
                                        }
                                        if (commandraw.length() > 0) {
                                            Character command = commandraw.charAt(0);
                                            StringBuilder arg = new StringBuilder();
                                            IntStream.range(2, commandraw.length() - 1).forEachOrdered(n -> arg.append(commandraw.charAt(n)));
                                            //Bukkit.broadcastMessage("Command: " + command + " Action: " + arg);
                                            String args = arg.toString();
                                            handleClick(command, args, playerP);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        ItemStack clicked = event.getItem();
        if (clicked != null) {
            if (clicked.getType() != Material.AIR) {
                if (clicked.hasItemMeta()) {
                    ItemMeta meta = clicked.getItemMeta();
                    if (meta != null) {
                        if (meta.hasLore()) {
                            List lore = meta.getLore();
                            if (lore != null) {
                                if (lore.size() > 0) {

                                    if (ChatColor.stripColor((String) lore.get(lore.size() - 1)).equals("InvasionBW")) {
                                        event.setCancelled(true);
                                    }
                                    if (lore.size() > 1) {
                                        String commandraw = ChatColor.stripColor((String) lore.get(lore.size() - 2));
                                        HumanEntity player = event.getPlayer();
                                        Player playerP = Bukkit.getPlayer(player.getName());
                                        if (playerP != null) {
                                            playerP.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1, 2);
                                        }
                                        if (commandraw.length() > 0) {
                                            Character command = commandraw.charAt(0);
                                            StringBuilder arg = new StringBuilder();
                                            IntStream.range(2, commandraw.length() - 1).forEachOrdered(n -> arg.append(commandraw.charAt(n)));
                                            //Bukkit.broadcastMessage("Command: " + command + " Action: " + arg);
                                            String args = arg.toString();
                                            handleClick(command, args, playerP);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}