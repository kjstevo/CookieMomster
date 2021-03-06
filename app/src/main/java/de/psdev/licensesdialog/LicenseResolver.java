/*
 * Copyright 2013 Philip Schiffer
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package de.psdev.licensesdialog;

import java.util.HashMap;
import java.util.Map;

import de.psdev.licensesdialog.licenses.ApacheSoftwareLicense20;
import de.psdev.licensesdialog.licenses.BSD3ClauseLicense;
import de.psdev.licensesdialog.licenses.GnuLicense20;
import de.psdev.licensesdialog.licenses.ISCLicense;
import de.psdev.licensesdialog.licenses.License;
import de.psdev.licensesdialog.licenses.MITLicense;

public class LicenseResolver {

    private static final int INITIAL_LICENSES_COUNT = 4;

    private static Map<String, License> sLicenses = new HashMap<String, License>(INITIAL_LICENSES_COUNT);

    static {
        registerLicense(new ApacheSoftwareLicense20());
        registerLicense(new GnuLicense20());
        registerLicense(new BSD3ClauseLicense());
        registerLicense(new ISCLicense());
        registerLicense(new MITLicense());
    }

    /**
     * Register an additional license.
     *
     * @param license the license to register
     */
    public static void registerLicense(final License license) {
        sLicenses.put(license.getName(), license);
    }

    public static License read(final String license) {
        final String trimmedLicense = license.trim();
        if (sLicenses.containsKey(trimmedLicense)) {
            return sLicenses.get(trimmedLicense);
        } else {
            throw new IllegalStateException(String.format("no such license available: %s, did you forget to register it?", trimmedLicense));
        }
    }
}
