fun main(args: Array<String>) {
    val bst = BinarySearchTree()
    bst.insert(50)
    bst.insert(30)
    bst.insert(20)
    bst.insert(70)
    bst.insert(80)
    bst.insert(40)
    bst.delete(50)
    bst.print()
}

class BinarySearchTree {

    private var node: Node? = null

    fun insert(value: Int) {
        node = insertValue(node, value)
    }

    fun delete(value: Int) {
        node = deleteValue(node, value)
    }

    fun print() {
        print(node)
    }

    private fun insertValue(node: Node?, value: Int): Node? {
        if (node == null) return Node(value)
        if (value < node.value) {
            node.left = insertValue(node.left, value)
        } else {
            node.right = insertValue(node.right, value)
        }
        return node
    }

    private fun deleteValue(node: Node?, value: Int): Node? {
        if (node == null) return node
        if (value < node.value) {
            node.left = deleteValue(node.left, value)
        } else if (value > node.value) {
            node.right = deleteValue(node.right, value)
        } else {
            if (node.left == null) return node.right
            else if (node.right == null) return node.left
            else {
                node.value = findMinValue(node.right)
                node.right = deleteValue(node.right, node.value)
            }
        }
        return node
    }

    private fun findMinValue(node: Node?): Int {
        return if (node == null) 0
        else if (node.left == null) node.value
        else findMinValue(node.left)
    }

    private fun print(node: Node?) {
        node?.run {
            print(node.left)
            println("${node.value}")
            print(node.right)
        }
    }
}

data class Node(var value:Int, var left: Node? = null, var right: Node? = null)