package zechs.contri.sync

import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    if (args.size != 2) {
        println("Usage: ContriSyncApp <username> <token>")
        return
    }
    runBlocking {
        ContriSyncApp().invoke(args[0], args[1])
    }
}