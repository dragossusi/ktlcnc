import java.io.File
import org.gradle.api.Project

object NativePaths {
  fun getNativePaths(project: Project): List<String> {
    val home = project.requirePath("LINUXCNC_HOME", "linuxcnc.home")
    val jdk = project.requirePath("LINUXCNC_JDK", "linuxcnc.jdk")
    return listOf(
      File(home, "lib").path,
      File(jdk, "lib").path,
    )
  }
}
