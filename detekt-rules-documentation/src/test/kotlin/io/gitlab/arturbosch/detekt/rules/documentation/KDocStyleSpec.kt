package io.gitlab.arturbosch.detekt.rules.documentation

import io.gitlab.arturbosch.detekt.test.compileAndLint
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class KDocStyleSpec {
    val subject = KDocStyle()

    @Nested
    inner class `check referenced multi rule to only lint errors once per case` {

        @Test
        fun `does only lint once`() {
            val code = """
            /** Some doc */
            class Test {
            }
            """
            assertThat(subject.compileAndLint(code)).hasSize(1)
        }
    }
}