package io.github.oaschi.paperwarp.dao;

import io.github.oaschi.paperwarp.PaperWarp;
import io.github.oaschi.paperwarp.domain.Home;

public class HomeDaoImpl extends HomeDao{

	public HomeDaoImpl(PaperWarp plugin) {
		super(plugin);
	}

	@Override
	public Home findByPlayer(String creator) {
		return getDatabase().find(Home.class).where().eq("creator", creator).findUnique();
	}

}