/*
 * Gandroid is an Android client for administrating Gandi services.
 *
 * Gandroid is distributed under GPL 3 license.
 *
 * Gandroid is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * Gandroid is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Gandroid. If not, see <http://www.gnu.org/licenses/>.
 *
 * For more information, please consult: <http://www.github.com/binseeds/gandroid>
 */

package net.gandi.rpclib;

import org.junit.Test;
import java.util.List;

import static org.junit.Assume.assumeNotNull;

/**
 * Not easy to unit test RPC, it requires a valid apikey,
 * this unit test does not update nor delete anything on Gandi.
 * @author Nicolas Fortin
 */
public class PortalTest {
    private static final String ENV_KEY = "gandi-api-key";

    private static Connection getConnection() throws Exception {
        return new Connection(true,System.getenv(ENV_KEY));
    }
    @Test
    public void testDomainList() throws Exception {
        assumeNotNull(System.getenv(ENV_KEY));
        Connection connection = getConnection();
        Portal portal = new Portal(connection);
        List<Domain> domainList = portal.getDomains();
    }
}
