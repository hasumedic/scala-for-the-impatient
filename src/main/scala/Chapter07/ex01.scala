package Chapter07

package com.horstmann {
  object Invisible {
    val invisible = "Invisible"
  }
}

package com {
  package horstmann {
    package impatient {
      class Visible {
        val visible = Invisible.invisible
      }
    }
  }
}

package com.horstmann.impatient {
  class Invisible {
    // It's not visible from here
    //val invisible = Invisible.invisible
  }
}
