fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {

    if(l1 == null) {
        return l2
    }

    if(l2 == null) {
        return l1
    }

    if(l1.`val` < l2.`val`) {
        l1.next = mergeTwoLists(l1.next, l2)
        return l1
    }

    l2.next = mergeTwoLists(l1, l2.next)
    return l2

}

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    if (lists.size == 1) {
        return lists[0]
    }
    if (lists.isEmpty()) {
        return null
    }
    var head = mergeTwoLists(lists[0], lists[1])
    for (i in 2 until lists.size) {
        head = mergeTwoLists(head, lists[i])
    }
    return head
}

fun mergeKListsDivide(lists: Array<ListNode?>): ListNode? {
    if (lists.isEmpty()) {
        return null
    }
    var interval = 1
    while (interval < lists.size) {
        println(lists.size)
        var i = 0
        while (i + interval < lists.size) {
            lists[i] = mergeTwoLists(lists[i], lists[i + interval])
            i += interval * 2
        }
        interval *= 2
    }
    return lists[0]
}

// Time complexity : O(Nlogk)O(N\log k)O(Nlogk) where k\text{k}k is the number of linked lists.