/*
 * Copyright (c) 2014.  Author:Steven Dees(kjstevokjmaster@gmail.com)
 *
 *     This program is free software; you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation; either version 2 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License along
 *     with this program; if not, write to the Free Software Foundation, Inc.,
 *     51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package net.kjmaster.cookiemom.scout.turnin;

import android.support.v4.app.FragmentActivity;

import net.kjmaster.cookiemom.dao.Scout;

import eu.inmite.android.lib.dialogs.SimpleDialogFragment;


@SuppressWarnings("MethodNameSameAsClassName")
public class ScoutTurnInDialog {
    public ScoutTurnInDialog() {
    }

    public void ScoutTurnInDialog(Scout scout, FragmentActivity activity) {
        SimpleDialogFragment.createBuilder(activity, activity.getSupportFragmentManager())
                .setTitle("Turn in for" + scout.getScoutName())
                .setMessage("Is she turning in money or cookies?")
                .setPositiveButtonText("Money")
                .setNegativeButtonText("Cookies")
                .setCancelable(true)
                .setRequestCode(scout.getId().intValue())
                .setTag(scout.getId().toString())
                .show();
    }
}