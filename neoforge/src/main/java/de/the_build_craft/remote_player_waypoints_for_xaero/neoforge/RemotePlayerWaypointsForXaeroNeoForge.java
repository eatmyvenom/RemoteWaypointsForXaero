/*      Remote player waypoints for Xaero's Map
        Copyright (C) 2024  Leander Knüttel

        This program is free software: you can redistribute it and/or modify
        it under the terms of the GNU General Public License as published by
        the Free Software Foundation, either version 3 of the License, or
        (at your option) any later version.

        This program is distributed in the hope that it will be useful,
        but WITHOUT ANY WARRANTY; without even the implied warranty of
        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
        GNU General Public License for more details.

        You should have received a copy of the GNU General Public License
        along with this program.  If not, see <https://www.gnu.org/licenses/>.*/


package de.the_build_craft.remote_player_waypoints_for_xaero.neoforge;

import com.mojang.brigadier.CommandDispatcher;
import de.the_build_craft.remote_player_waypoints_for_xaero.RemotePlayerWaypointsForXaero;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterClientCommandsEvent;
import net.neoforged.neoforge.common.NeoForge;

@Mod(RemotePlayerWaypointsForXaero.MOD_ID)
public final class RemotePlayerWaypointsForXaeroNeoForge {
    public RemotePlayerWaypointsForXaeroNeoForge() {
        RemotePlayerWaypointsForXaero.loaderType = RemotePlayerWaypointsForXaero.LoaderType.NeoForge;
        var config = new CommonModConfigNeoForge();

        // Run our common setup.
        RemotePlayerWaypointsForXaero.init();

        NeoForge.EVENT_BUS.addListener(this::onCommandRegister);
    }
    public void onCommandRegister(RegisterClientCommandsEvent event) {
        RemotePlayerWaypointsForXaero.register((CommandDispatcher) event.getDispatcher());
    }
}
