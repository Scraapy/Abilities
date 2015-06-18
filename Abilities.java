package me.Scrap.Abilities;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Abilities
  extends JavaPlugin
{
  public void onEnable()
  {
    getLogger().info("Abilities have been enabled");
    getConfig().options().copyDefaults(true);
    saveConfig();
  }
  
  public void onDisable()
  {
    getLogger().info("Abilities have been enabled");
  }
  
  HashMap<String, Long> map = new HashMap();
  int GlobalCooldown = 0;
  int SpeedAmmount = 0;
  int SpeedTime = 0;
  int JumpAmmount = 0;
  int JumpTime = 0;
  int StrengthAmmount = 0;
  int StrengthTime = 0;
  int AirAmmount = 0;
  int AirTime = 0;
  int FireAmmount = 0;
  int FireTime = 0;
  int DigAmmount = 0;
  int DigTime = 0;
  int RisAmmount = 0;
  int RisTime = 0;
  int RegAmmount = 0;
  int RegTime = 0;
  int InvTime = 0;
  int SeeTime = 0;
  
  String ToTheColorMobile(String ColorMobileAway)
  {
    ColorMobileAway = ColorMobileAway.replaceAll("&", "§");
    return ColorMobileAway;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if ((sender instanceof Player))
    {
      Player player = (Player)sender;
      if (cmd.getName().equalsIgnoreCase("eSpeed"))
      {
        if (this.map.containsKey(sender.getName()))
        {
          long diff = (System.currentTimeMillis() - ((Long)this.map.get(sender.getName())).longValue()) / 1000L / 60L;
          this.GlobalCooldown = getConfig().getInt("Settings.GlobalCooldown");
          if (diff < this.GlobalCooldown)
          {
            sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Abilities" + ChatColor.GRAY + "]: " + ChatColor.RED + "Please wait " + (this.GlobalCooldown - diff) + " minutes until using another ability");
            return true;
          }
        }
        this.SpeedAmmount = getConfig().getInt("Settings.SpeedAmmount");
        this.SpeedTime = getConfig().getInt("Settings.SpeedTime");
        sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Abilities" + ChatColor.GRAY + "]: " + ChatColor.GREEN + "Speed " + this.SpeedAmmount + " is toggled for " + this.SpeedTime + " Minutes(s)");
        Player s = (Player)sender;
        s.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200 * this.SpeedTime, this.SpeedAmmount));
        if (getConfig().getString("Settings.Effects").equals("true"))
        {
          World world = s.getWorld();
          Location location = s.getLocation();
          world.strikeLightningEffect(location);
          s.getWorld().playSound(location, Sound.FIREWORK_BLAST, 3.4028235E+38F, 1.175494E-038F);
          for (int i = 0; i <= 8; i++) {
              s.getWorld().playEffect(s.getLocation(), Effect.EXPLOSION_HUGE, i);
          }
          for (int i = 0; i <= 8; i++) {
            s.getWorld().playEffect(s.getLocation(), Effect.HAPPY_VILLAGER, i);
          }
          for (int i = 0; i <= 8; i++) {
            s.getWorld().playEffect(s.getLocation(), Effect.ENDER_SIGNAL, i);
          }
          sender.sendMessage(ToTheColorMobile(getConfig().getString("Messages.Speed")));
          this.map.put(sender.getName(), Long.valueOf(System.currentTimeMillis()));
          return true;
        }
        sender.sendMessage(ToTheColorMobile(getConfig().getString("Messages.Speed")));
        this.map.put(sender.getName(), Long.valueOf(System.currentTimeMillis()));
        return true;
      }
      if (cmd.getName().equalsIgnoreCase("eStrength"))
      {
        if (this.map.containsKey(sender.getName()))
        {
          long diff = (System.currentTimeMillis() - ((Long)this.map.get(sender.getName())).longValue()) / 1000L / 60L;
          this.GlobalCooldown = getConfig().getInt("Settings.GlobalCooldown");
          if (diff < this.GlobalCooldown)
          {
              sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Abilities" + ChatColor.GRAY + "]: " + ChatColor.RED + "Please wait " + (this.GlobalCooldown - diff) + " minutes until using another ability");
            return true;
          }
        }
        this.StrengthAmmount = getConfig().getInt("Settings.StrengthAmmount");
        this.StrengthTime = getConfig().getInt("Settings.StrengthTime");
        sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Abilities" + ChatColor.GRAY + "]: " + ChatColor.GREEN + "Strength " + this.StrengthAmmount + " is toggled for " + this.StrengthTime + " Minute(s)");
        Player s = (Player)sender;
        s.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1200 * this.StrengthTime, this.StrengthAmmount));
        if (getConfig().getString("Settings.Effects").equals("true"))
        {
          World world = s.getWorld();
          Location location = s.getLocation();
          world.strikeLightningEffect(location);
          s.getWorld().playSound(location, Sound.FIREWORK_BLAST, 3.4028235E+38F, 1.175494E-038F);
          for (int i = 0; i <= 8; i++) {
              s.getWorld().playEffect(s.getLocation(), Effect.EXPLOSION_HUGE, i);
          }
          for (int i = 0; i <= 8; i++) {
            s.getWorld().playEffect(s.getLocation(), Effect.HAPPY_VILLAGER, i);
          }
          for (int i = 0; i <= 8; i++) {
            s.getWorld().playEffect(s.getLocation(), Effect.ENDER_SIGNAL, i);
          }
          sender.sendMessage(ToTheColorMobile(getConfig().getString("Messages.Strength")));
          this.map.put(sender.getName(), Long.valueOf(System.currentTimeMillis()));
          return true;
        }
        sender.sendMessage(ToTheColorMobile(getConfig().getString("Messages.Strength")));
        this.map.put(sender.getName(), Long.valueOf(System.currentTimeMillis()));
        return true;
      }
      if (cmd.getName().equalsIgnoreCase("eJump"))
      {
        if (this.map.containsKey(sender.getName()))
        {
          long diff = (System.currentTimeMillis() - ((Long)this.map.get(sender.getName())).longValue()) / 1000L / 60L;
          this.GlobalCooldown = getConfig().getInt("Settings.GlobalCooldown");
          if (diff < this.GlobalCooldown)
          {
              sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Abilities" + ChatColor.GRAY + "]: " + ChatColor.RED + "Please wait " + (this.GlobalCooldown - diff) + " minutes until using another ability");
            return true;
          }
        }
        this.JumpAmmount = getConfig().getInt("Settings.JumpAmmount");
        this.JumpTime = getConfig().getInt("Settings.JumpTime");
        sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Abilities" + ChatColor.GRAY + "]: " + ChatColor.GREEN + "Jump Boost " + this.JumpAmmount + " is toggled for " + this.JumpTime + " Minute(s)");
        Player s = (Player)sender;
        s.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1200 * this.JumpTime, this.JumpAmmount));
        if (getConfig().getString("Settings.Effects").equals("true"))
        {
          World world = s.getWorld();
          Location location = s.getLocation();
          world.strikeLightningEffect(location);
          s.getWorld().playSound(location, Sound.FIREWORK_BLAST, 3.4028235E+38F, 1.175494E-038F);
          for (int i = 0; i <= 8; i++) {
              s.getWorld().playEffect(s.getLocation(), Effect.EXPLOSION_HUGE, i);
          }
          for (int i = 0; i <= 8; i++) {
            s.getWorld().playEffect(s.getLocation(), Effect.HAPPY_VILLAGER, i);
          }
          for (int i = 0; i <= 8; i++) {
            s.getWorld().playEffect(s.getLocation(), Effect.ENDER_SIGNAL, i);
          }
          sender.sendMessage(ToTheColorMobile(getConfig().getString("Messages.Jump")));
          this.map.put(sender.getName(), Long.valueOf(System.currentTimeMillis()));
          return true;
        }
        sender.sendMessage(ToTheColorMobile(getConfig().getString("Messages.Jump")));
        this.map.put(sender.getName(), Long.valueOf(System.currentTimeMillis()));
        return true;
      }
      if (cmd.getName().equalsIgnoreCase("eAir"))
      {
        if (this.map.containsKey(sender.getName()))
        {
          long diff = (System.currentTimeMillis() - ((Long)this.map.get(sender.getName())).longValue()) / 1000L / 60L;
          this.GlobalCooldown = getConfig().getInt("Settings.GlobalCooldown");
          if (diff < this.GlobalCooldown)
          {
              sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Abilities" + ChatColor.GRAY + "]: " + ChatColor.RED + "Please wait " + (this.GlobalCooldown - diff) + " minutes until using another ability");
            return true;
          }
        }
        this.AirAmmount = getConfig().getInt("Settings.AirAmmount");
        this.AirTime = getConfig().getInt("Settings.AirTime");
        sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Abilities" + ChatColor.GRAY + "]: " + ChatColor.GREEN + "Water Breating " + this.AirAmmount + " is toggled for " + this.AirTime + " Minute(s)");
        Player s = (Player)sender;
        s.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 1200 * this.AirTime, this.AirAmmount));
        if (getConfig().getString("Settings.Effects").equals("true"))
        {
          World world = s.getWorld();
          Location location = s.getLocation();
          world.strikeLightningEffect(location);
          s.getWorld().playSound(location, Sound.FIREWORK_BLAST, 3.4028235E+38F, 1.175494E-038F);
          for (int i = 0; i <= 8; i++) {
            s.getWorld().playEffect(s.getLocation(), Effect.EXPLOSION_HUGE, i);
          }
          for (int i = 0; i <= 8; i++) {
            s.getWorld().playEffect(s.getLocation(), Effect.HAPPY_VILLAGER, i);
          }
          for (int i = 0; i <= 8; i++) {
            s.getWorld().playEffect(s.getLocation(), Effect.ENDER_SIGNAL, i);
          }
          sender.sendMessage(ToTheColorMobile(getConfig().getString("Messages.Air")));
          this.map.put(sender.getName(), Long.valueOf(System.currentTimeMillis()));
          return true;
        }
        sender.sendMessage(ToTheColorMobile(getConfig().getString("Messages.Air")));
        this.map.put(sender.getName(), Long.valueOf(System.currentTimeMillis()));
        return true;
      }
      if (cmd.getName().equalsIgnoreCase("aFire"))
      {
        if (this.map.containsKey(sender.getName()))
        {
          long diff = (System.currentTimeMillis() - ((Long)this.map.get(sender.getName())).longValue()) / 1000L / 60L;
          this.GlobalCooldown = getConfig().getInt("Settings.GlobalCooldown");
          if (diff < this.GlobalCooldown)
          {
              sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Abilities" + ChatColor.GRAY + "]: " + ChatColor.RED + "Please wait " + (this.GlobalCooldown - diff) + " minutes until using another ability");
            return true;
          }
        }
        this.FireAmmount = getConfig().getInt("Settings.FireAmmount");
        this.FireTime = getConfig().getInt("Settings.FireTime");
        sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Abilities" + ChatColor.GRAY + "]: " + ChatColor.GREEN + "Fire Resistance " + this.FireAmmount + " is toggled for " + this.FireTime + " Minute(s)");
        Player s = (Player)sender;
        s.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1200 * this.FireTime, this.FireAmmount));
        if (getConfig().getString("Settings.Effects").equals("true"))
        {
          World world = s.getWorld();
          Location location = s.getLocation();
          world.strikeLightningEffect(location);
          s.getWorld().playSound(location, Sound.FIREWORK_BLAST, 3.4028235E+38F, 1.175494E-038F);
          for (int i = 0; i <= 8; i++) {
              s.getWorld().playEffect(s.getLocation(), Effect.EXPLOSION_HUGE, i);
          }
          for (int i = 0; i <= 8; i++) {
            s.getWorld().playEffect(s.getLocation(), Effect.HAPPY_VILLAGER, i);
          }
          for (int i = 0; i <= 8; i++) {
            s.getWorld().playEffect(s.getLocation(), Effect.ENDER_SIGNAL, i);
          }
          sender.sendMessage(ToTheColorMobile(getConfig().getString("Messages.FireResistance")));
          this.map.put(sender.getName(), Long.valueOf(System.currentTimeMillis()));
          return true;
        }
        sender.sendMessage(ToTheColorMobile(getConfig().getString("Messages.FireResistance")));
        this.map.put(sender.getName(), Long.valueOf(System.currentTimeMillis()));
        return true;
      }
      if (cmd.getName().equalsIgnoreCase("eHaste"))
      {
        if (this.map.containsKey(sender.getName()))
        {
          long diff = (System.currentTimeMillis() - ((Long)this.map.get(sender.getName())).longValue()) / 1000L / 60L;
          this.GlobalCooldown = getConfig().getInt("Settings.GlobalCooldown");
          if (diff < this.GlobalCooldown)
          {
              sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Abilities" + ChatColor.GRAY + "]: " + ChatColor.RED + "Please wait " + (this.GlobalCooldown - diff) + " minutes until using another ability");
            return true;
          }
        }
        this.DigTime = getConfig().getInt("Settings.DigTime");
        this.DigAmmount = getConfig().getInt("Settings.DigAmmount");
        sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Abilities" + ChatColor.GRAY + "]: " + ChatColor.GREEN + "Haste " + this.DigAmmount + " is toggled for " + this.DigTime + " Minutes(s)");
        Player s = (Player)sender;
        s.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1200 * this.DigTime, this.DigAmmount));
        if (getConfig().getString("Settings.Effects").equals("true"))
        {
          World world = s.getWorld();
          Location location = s.getLocation();
          world.strikeLightningEffect(location);
          s.getWorld().playSound(location, Sound.FIREWORK_BLAST, 3.4028235E+38F, 1.175494E-038F);
          for (int i = 0; i <= 8; i++) {
              s.getWorld().playEffect(s.getLocation(), Effect.EXPLOSION_HUGE, i);
          }
          for (int i = 0; i <= 8; i++) {
            s.getWorld().playEffect(s.getLocation(), Effect.HAPPY_VILLAGER, i);
          }
          for (int i = 0; i <= 8; i++) {
            s.getWorld().playEffect(s.getLocation(), Effect.ENDER_SIGNAL, i);
          }
          sender.sendMessage(ToTheColorMobile(getConfig().getString("Messages.Dig")));
          this.map.put(sender.getName(), Long.valueOf(System.currentTimeMillis()));
          return true;
        }
        sender.sendMessage(ToTheColorMobile(getConfig().getString("Messages.Dig")));
        this.map.put(sender.getName(), Long.valueOf(System.currentTimeMillis()));
        return true;
      }
      if (cmd.getName().equalsIgnoreCase("eResistance"))
      {
        if (this.map.containsKey(sender.getName()))
        {
          long diff = (System.currentTimeMillis() - ((Long)this.map.get(sender.getName())).longValue()) / 1000L / 60L;
          this.GlobalCooldown = getConfig().getInt("Settings.GlobalCooldown");
          if (diff < this.GlobalCooldown)
          {
              sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Abilities" + ChatColor.GRAY + "]: " + ChatColor.RED + "Please wait " + (this.GlobalCooldown - diff) + " minutes until using another ability");
            return true;
          }
        }
        this.RisTime = getConfig().getInt("Settings.RisTime");
        this.RisAmmount = getConfig().getInt("Settings.RisAmmount");
        sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Abilities" + ChatColor.GRAY + "]: " + ChatColor.GREEN + "Resistance " + this.RisAmmount + " is toggled for " + this.RisTime + " Minutes(s)");
        Player s = (Player)sender;
        s.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1200 * this.RisTime, this.RisAmmount));
        if (getConfig().getString("Settings.Effects").equals("true"))
        {
          World world = s.getWorld();
          Location location = s.getLocation();
          world.strikeLightningEffect(location);
          s.getWorld().playSound(location, Sound.FIREWORK_BLAST, 3.4028235E+38F, 1.175494E-038F);
          for (int i = 0; i <= 8; i++) {
              s.getWorld().playEffect(s.getLocation(), Effect.EXPLOSION_HUGE, i);
          }
          for (int i = 0; i <= 8; i++) {
            s.getWorld().playEffect(s.getLocation(), Effect.HAPPY_VILLAGER, i);
          }
          for (int i = 0; i <= 8; i++) {
            s.getWorld().playEffect(s.getLocation(), Effect.ENDER_SIGNAL, i);
          }
          sender.sendMessage(ToTheColorMobile(getConfig().getString("Messages.Resistance")));
          this.map.put(sender.getName(), Long.valueOf(System.currentTimeMillis()));
          return true;
        }
        sender.sendMessage(ToTheColorMobile(getConfig().getString("Messages.Resistance")));
        this.map.put(sender.getName(), Long.valueOf(System.currentTimeMillis()));
        return true;
      }
      if (cmd.getName().equalsIgnoreCase("eRegeneration"))
      {
        if (this.map.containsKey(sender.getName()))
        {
          long diff = (System.currentTimeMillis() - ((Long)this.map.get(sender.getName())).longValue()) / 1000L / 60L;
          this.GlobalCooldown = getConfig().getInt("Settings.GlobalCooldown");
          if (diff < this.GlobalCooldown)
          {
              sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Abilities" + ChatColor.GRAY + "]: " + ChatColor.RED + "Please wait " + (this.GlobalCooldown - diff) + " minutes until using another ability");
            return true;
          }
        }
        this.RegTime = getConfig().getInt("Settings.RegTime");
        this.RegAmmount = getConfig().getInt("Settings.RegAmmount");
        sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Abilities" + ChatColor.GRAY + "]: " + ChatColor.GREEN + "Regeneration " + this.RegAmmount + " is toggled for " + this.RegTime + " Second(s)");
        Player s = (Player)sender;
        s.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20 * this.RegTime, this.RegAmmount));
        if (getConfig().getString("Settings.Effects").equals("true"))
        {
          World world = s.getWorld();
          Location location = s.getLocation();
          world.strikeLightningEffect(location);
          s.getWorld().playSound(location, Sound.FIREWORK_BLAST, 3.4028235E+38F, 1.175494E-038F);
          for (int i = 0; i <= 8; i++) {
              s.getWorld().playEffect(s.getLocation(), Effect.EXPLOSION_HUGE, i);
          }
          for (int i = 0; i <= 8; i++) {
            s.getWorld().playEffect(s.getLocation(), Effect.HAPPY_VILLAGER, i);
          }
          for (int i = 0; i <= 8; i++) {
            s.getWorld().playEffect(s.getLocation(), Effect.ENDER_SIGNAL, i);
          }
          sender.sendMessage(ToTheColorMobile(getConfig().getString("Messages.Regeneration")));
          this.map.put(sender.getName(), Long.valueOf(System.currentTimeMillis()));
          return true;
        }
        sender.sendMessage(ToTheColorMobile(getConfig().getString("Messages.Regeneration")));
        this.map.put(sender.getName(), Long.valueOf(System.currentTimeMillis()));
        return true;
      }
      if (cmd.getName().equalsIgnoreCase("eInvisibility"))
      {
        if (this.map.containsKey(sender.getName()))
        {
          long diff = (System.currentTimeMillis() - ((Long)this.map.get(sender.getName())).longValue()) / 1000L / 60L;
          this.GlobalCooldown = getConfig().getInt("Settings.GlobalCooldown");
          if (diff < this.GlobalCooldown)
          {
              sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Abilities" + ChatColor.GRAY + "]: " + ChatColor.RED + "Please wait " + (this.GlobalCooldown - diff) + " minutes until using another ability");
            return true;
          }
        }
        this.InvTime = getConfig().getInt("Settings.InvTime");
        
        sender.sendMessage(ChatColor.BLUE + "You have gone invisible for " + this.InvTime + " Minutes(s)");
        Player s = (Player)sender;
        s.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1200 * this.InvTime, 1));
        if (getConfig().getString("Settings.Effects").equals("true"))
        {
          World world = s.getWorld();
          Location location = s.getLocation();
          world.strikeLightningEffect(location);
          s.getWorld().playSound(location, Sound.FIREWORK_BLAST, 3.4028235E+38F, 1.175494E-038F);
          for (int i = 0; i <= 8; i++) {
              s.getWorld().playEffect(s.getLocation(), Effect.EXPLOSION_HUGE, i);
          }
          for (int i = 0; i <= 8; i++) {
            s.getWorld().playEffect(s.getLocation(), Effect.HAPPY_VILLAGER, i);
          }
          for (int i = 0; i <= 8; i++) {
            s.getWorld().playEffect(s.getLocation(), Effect.ENDER_SIGNAL, i);
          }
          sender.sendMessage(ToTheColorMobile(getConfig().getString("Messages.Invisibility")));
          this.map.put(sender.getName(), Long.valueOf(System.currentTimeMillis()));
          return true;
        }
        sender.sendMessage(ToTheColorMobile(getConfig().getString("Messages.Invisibility")));
        this.map.put(sender.getName(), Long.valueOf(System.currentTimeMillis()));
        return true;
      }
      Location location;
      if (cmd.getName().equalsIgnoreCase("eNightVision"))
      {
        if (this.map.containsKey(sender.getName()))
        {
          long diff = (System.currentTimeMillis() - ((Long)this.map.get(sender.getName())).longValue()) / 1000L / 60L;
          this.GlobalCooldown = getConfig().getInt("Settings.GlobalCooldown");
          if (diff < this.GlobalCooldown)
          {
              sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Abilities" + ChatColor.GRAY + "]: " + ChatColor.RED + "Please wait " + (this.GlobalCooldown - diff) + " minutes until using another ability");
            return true;
          }
        }
        this.SeeTime = getConfig().getInt("Settings.SeeTime");
        
        sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Abilities" + ChatColor.GRAY + "]: " + ChatColor.GREEN + "Nightvision toggled for " + this.SeeTime + " Minutes(s)");
        Player s = (Player)sender;
        s.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1200 * this.SeeTime, 1));
        if (getConfig().getString("Settings.Effects").equals("true"))
        {
          World world = s.getWorld();
          location = s.getLocation();
          world.strikeLightningEffect(location);
          s.getWorld().playSound(location, Sound.FIREWORK_BLAST, 3.4028235E+38F, 1.175494E-038F);
          for (int i = 0; i <= 8; i++) {
              s.getWorld().playEffect(s.getLocation(), Effect.EXPLOSION_HUGE, i);
          }
          for (int i = 0; i <= 8; i++) {
            s.getWorld().playEffect(s.getLocation(), Effect.HAPPY_VILLAGER, i);
          }
          for (int i = 0; i <= 8; i++) {
            s.getWorld().playEffect(s.getLocation(), Effect.ENDER_SIGNAL, i);
          }
          sender.sendMessage(ToTheColorMobile(getConfig().getString("Messages.NightVision")));
          this.map.put(sender.getName(), Long.valueOf(System.currentTimeMillis()));
          return true;
        }
        sender.sendMessage(ToTheColorMobile(getConfig().getString("Messages.NightVision")));
        this.map.put(sender.getName(), Long.valueOf(System.currentTimeMillis()));
        return true;
      }
      if (cmd.getName().equalsIgnoreCase("eRemove"))
      {
        sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Abilities" + ChatColor.GRAY + "]: " + ChatColor.GREEN + "All potion effects have been cleared!");
        Player s = (Player)sender;
        for (PotionEffect effect : s.getActivePotionEffects()) {
          s.removePotionEffect(effect.getType());
        }
        return true;
      }
      if (cmd.getName().equalsIgnoreCase("ebilreload"))
      {
        reloadConfig();
        saveConfig();
        getConfig();
        sender.sendMessage(ChatColor.GREEN + "Config file reload.");
        return true;
      }
      if (cmd.getName().equalsIgnoreCase("alist"))
      {
        this.SpeedAmmount = getConfig().getInt("Settings.SpeedAmmount");
        this.SpeedTime = getConfig().getInt("Settings.SpeedTime");
        this.StrengthAmmount = getConfig().getInt("Settings.StrengthAmmount");
        this.StrengthTime = getConfig().getInt("Settings.StrengthTime");
        this.JumpAmmount = getConfig().getInt("Settings.JumpAmmount");
        this.JumpTime = getConfig().getInt("Settings.JumpTime");
        this.AirAmmount = getConfig().getInt("Settings.AirAmmount");
        this.AirTime = getConfig().getInt("Settings.AirTime");
        this.FireAmmount = getConfig().getInt("Settings.FireAmmount");
        this.FireTime = getConfig().getInt("Settings.FireTime");
        this.DigTime = getConfig().getInt("Settings.DigTime");
        this.DigAmmount = getConfig().getInt("Settings.DigAmmount");
        this.RisTime = getConfig().getInt("Settings.RisTime");
        this.RisAmmount = getConfig().getInt("Settings.RisAmmount");
        this.RegTime = getConfig().getInt("Settings.RegTime");
        this.RegAmmount = getConfig().getInt("Settings.RegAmmount");
        this.InvTime = getConfig().getInt("Settings.InvTime");
        this.SeeTime = getConfig().getInt("Settings.SeeTime");
        sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Abilities" + ChatColor.GRAY + "]: " + ChatColor.GREEN + "Speed - Factor " + this.SpeedAmmount + " - Length " + this.SpeedTime + " Minute(s).");
        sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Abilities" + ChatColor.GRAY + "]: " + ChatColor.GREEN + "Jump - Factor " + this.JumpAmmount + " - Length " + this.JumpTime + " Minute(s).");
        sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Abilities" + ChatColor.GRAY + "]: " + ChatColor.GREEN + "Strength - Factor " + this.StrengthAmmount + " - Length " + this.StrengthTime + " Minute(s).");
        sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Abilities" + ChatColor.GRAY + "]: " + ChatColor.GREEN + "Air - Factor " + this.AirAmmount + " - Length " + this.AirTime + " Minute(s).");
        sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Abilities" + ChatColor.GRAY + "]: " + ChatColor.GREEN + "Fire Resistance - Factor " + this.FireAmmount + " - Length " + this.FireTime + " Minute(s).");
        sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Abilities" + ChatColor.GRAY + "]: " + ChatColor.GREEN + "Dig Speed - Factor " + this.DigAmmount + " - Length " + this.DigTime + " Minute(s).");
        sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Abilities" + ChatColor.GRAY + "]: " + ChatColor.GREEN + "Damage Resistance - Factor " + this.RisAmmount + " - Length " + this.RisTime + " Minute(s).");
        sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Abilities" + ChatColor.GRAY + "]: " + ChatColor.GREEN + "Regenration - Factor " + this.RegAmmount + " - Length " + this.RegTime + " Second(s).");
        sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Abilities" + ChatColor.GRAY + "]: " + ChatColor.GREEN + "Invisibility - Length " + this.InvTime + " Minute(s).");
        sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "Abilities" + ChatColor.GRAY + "]: " + ChatColor.GREEN + "Night Vision - Length " + this.SeeTime + " Minute(s).");
        return true;
      }
    }
    else
    {
      sender.sendMessage("Console cannout use this plugin");
      return false;
    }
    return false;
  }
}
