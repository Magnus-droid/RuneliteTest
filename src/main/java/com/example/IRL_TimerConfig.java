package com.example;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Units;


@ConfigGroup(IRL_TimerConfig.GROUP)
public interface IRL_TimerConfig extends Config
{
	String GROUP = "IRL_Timer";

	@ConfigItem(
		keyName = "greeting",
		name = "Welcome Greeting",
		description = "The message to show to the user when they login"
	)
	@Units(Units.MINUTES)
	default int timer()
	{
		return 10;
	}
}
