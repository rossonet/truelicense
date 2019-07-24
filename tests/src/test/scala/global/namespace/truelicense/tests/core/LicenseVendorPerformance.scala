/*
 * Copyright (C) 2005 - 2019 Schlichtherle IT Services.
 * All rights reserved. Use is subject to license terms.
 */
package global.namespace.truelicense.tests.core

import java.util.concurrent.Callable

import global.namespace.fun.io.bios.BIOS.memory

trait LicenseVendorPerformance extends Callable[Unit] { this: TestContext =>

  def call(): Unit = {
    for (i <- 1 to 5) {
      val vm = vendorManager
      val num = 1000
      val start = System.nanoTime
      for (j <- 1 to num) {
        vm generateKeyFrom license saveTo memory
      }
      val time = System.nanoTime - start
      printf("Iteration %d generated %,d license keys per second.\n", i, num * 1000L * 1000L * 1000L / time)
    }
  }
}
