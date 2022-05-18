object NativePaths {
    fun getNativePaths(): List<String> {
        val home = requireEnv("LINUXCNC_HOME")
        val jdk = requireEnv("LINUXCNC_JDK")
        return listOf(
            "$home/lib",
            "$jdk/lib",
            //native path
            //linuxcnc/lib
            //jdk/lib
        )
    }

    private fun requireEnv(name: String) = System.getenv(name)
        ?: throw IllegalArgumentException("$name env not set")
}