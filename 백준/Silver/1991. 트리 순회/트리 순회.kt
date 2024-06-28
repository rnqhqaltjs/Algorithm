fun main() {
    val n = readln().toInt()

    val tree = Array(26) { IntArray(2) }


    for(i in 0 until n) {
        val (node, left, right) = readln().split(" ")

        val nodeIndex = node[0].code - 'A'.code

        if(left == ".") {
            tree[nodeIndex][0] = -1
        } else {
            tree[nodeIndex][0] = left[0].code - 'A'.code
        }

        if(right == ".") {
            tree[nodeIndex][1] = -1
        } else {
            tree[nodeIndex][1] = right[0].code - 'A'.code
        }
    }

    preOrder(0, tree)
    println()
    inOrder(0, tree)
    println()
    postOrder(0, tree)
}

fun preOrder(root: Int, tree: Array<IntArray>) {
    if(root == -1) return
    print((root + 'A'.code).toChar())
    preOrder(tree[root][0], tree)
    preOrder(tree[root][1], tree)
}

fun inOrder(root: Int, tree: Array<IntArray>) {
    if(root == -1) return
    inOrder(tree[root][0], tree)
    print((root + 'A'.code).toChar())
    inOrder(tree[root][1], tree)
}

fun postOrder(root: Int, tree: Array<IntArray>) {
    if(root == -1) return
    postOrder(tree[root][0], tree)
    postOrder(tree[root][1], tree)
    print((root + 'A'.code).toChar())
}