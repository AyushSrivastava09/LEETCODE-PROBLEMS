class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head.next == null) return head;
        ListNode headNew = head, tempOuter = head.next, lastInner = headNew, prevOuter = head;
        while (tempOuter != null) {
            ListNode tempOuterCopy = tempOuter;
            tempOuter = tempOuter.next;
            if (lastInner.val > tempOuterCopy.val) {
                if (tempOuterCopy.val < headNew.val) {
                    if (headNew.next != null && headNew.next.equals(tempOuterCopy)) {
                        headNew.next = null;
                    }
                    tempOuterCopy.next = headNew;
                    headNew = tempOuterCopy;
                } else {
                    ListNode fromHead = headNew, prevInner = headNew;
                    while (fromHead != null) {
                        if (tempOuterCopy.val < fromHead.val) {
                            prevInner.next = tempOuterCopy;
                            tempOuterCopy.next = fromHead;
                            if (fromHead.next != null && fromHead.next.equals(tempOuterCopy)) fromHead.next = null;
                            break;
                        }
                        prevInner = fromHead;
                        fromHead = fromHead.next;
                    }
                }
            } else {
                tempOuterCopy.next = null;
                lastInner.next = tempOuterCopy;
                lastInner = lastInner.next;
            }
        }
        return headNew;
    }
}