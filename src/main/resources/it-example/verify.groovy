import java.io.*
import java.util.*

def currentFolder = new File(basedir, ".").getCanonicalPath() + "/";

def logFileInput = new File(basedir, "build.log")

new File(basedir, "build-filtered.log").withWriter { out ->
    logFileInput.eachLine { line ->

        if (line.contains(currentFolder)) {
            line = line.replace(currentFolder, "/home/maui/");
        }
       
        if (    !line.startsWith("Download") 
            &&  !line.startsWith(" wagon http use")
            &&  !line.startsWith("Running post-build")
            &&  !line.startsWith("Finished post-build ")) {
            out.println line;
        }
    }
}

return true;