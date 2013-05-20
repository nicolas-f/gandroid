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

/**
 * A domain owned by the user
 * @author Nicolas Fortin
 */
public class Domain {
    private final Connection connection;
    private final String domainName;

    public Domain(Connection connection, String domainName) {
        this.connection = connection;
        this.domainName = domainName;
    }
}
