package org.mariadb.jdbc.unit.client;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.client.ServerVersion;

public class ServerVersionTest {

  @Test
  public void check() throws Exception {
    ServerVersion ver = new ServerVersion("10.5.2", true);
    assertEquals(10, ver.getMajorVersion());
    assertEquals(5, ver.getMinorVersion());
    assertEquals(2, ver.getPatchVersion());
    assertEquals("10.5.2", ver.getServerVersion());
    assertTrue(ver.isMariaDBServer());
    assertTrue(ver.versionGreaterOrEqual(10, 5, 1));
    assertTrue(ver.versionGreaterOrEqual(10, 4, 5));
    assertTrue(ver.versionGreaterOrEqual(5, 6, 5));
    assertTrue(ver.versionGreaterOrEqual(10, 5, 2));
    assertFalse(ver.versionGreaterOrEqual(10, 5, 3));
    assertFalse(ver.versionGreaterOrEqual(10, 6, 0));
    assertFalse(ver.versionGreaterOrEqual(11, 0, 0));

    ver = new ServerVersion("10.5.2-MariaDB", true);
    assertEquals(10, ver.getMajorVersion());
    assertEquals(5, ver.getMinorVersion());
    assertEquals(2, ver.getPatchVersion());
    assertEquals("10.5.2-MariaDB", ver.getServerVersion());
    assertTrue(ver.isMariaDBServer());
    assertTrue(ver.versionGreaterOrEqual(10, 5, 1));
    assertTrue(ver.versionGreaterOrEqual(10, 4, 5));
    assertTrue(ver.versionGreaterOrEqual(5, 6, 5));
    assertTrue(ver.versionGreaterOrEqual(10, 5, 2));
    assertFalse(ver.versionGreaterOrEqual(10, 5, 3));
    assertFalse(ver.versionGreaterOrEqual(10, 6, 0));
    assertFalse(ver.versionGreaterOrEqual(11, 0, 0));

    ver = new ServerVersion("8.0.12-something", false);
    assertEquals(8, ver.getMajorVersion());
    assertEquals(0, ver.getMinorVersion());
    assertEquals(12, ver.getPatchVersion());
    assertEquals("8.0.12-something", ver.getServerVersion());
    assertFalse(ver.isMariaDBServer());
  }
}
