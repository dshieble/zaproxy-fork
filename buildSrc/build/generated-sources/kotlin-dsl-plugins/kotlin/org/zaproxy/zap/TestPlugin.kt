package org.zaproxy.zap


/**
 * Precompiled [test.gradle.kts][org.zaproxy.zap.Test_gradle] script plugin.
 *
 * @see org.zaproxy.zap.Test_gradle
 */
public
class TestPlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("org.zaproxy.zap.Test_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
