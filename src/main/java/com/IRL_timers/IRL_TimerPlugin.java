package com.IRL_timers;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import net.runelite.client.util.ImageUtil;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.NavigationButton;

import net.runelite.client.ui.ClientToolbar;

@Slf4j
@PluginDescriptor(
	name = "IRL Timers"
)

public class IRL_TimerPlugin extends Plugin
{

	private IRL_TimerPanel panel;
	private NavigationButton navButton;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	@Getter
	public IRL_TimerConfig config;

	@Override
	protected void startUp() throws Exception
	{
		panel = new IRL_TimerPanel(this);

		navButton = NavigationButton.builder()
				.tooltip("IRL_Timers")
				.icon(ImageUtil.loadImageResource(getClass(), "/WhmIcon.png"))
				.priority(10)
				.panel(panel)
				.build();

		clientToolbar.addNavigation(navButton);
		log.info("IRL_timers started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		clientToolbar.removeNavigation(navButton);
		log.info("IRL_timers stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() != GameState.LOGGED_IN)
		{


			//set variables to default

			//Leftovers from example plugin: client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Example says " + Instant.now(), null);
		}
	}


	@Provides
	IRL_TimerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(IRL_TimerConfig.class);
	}
}
