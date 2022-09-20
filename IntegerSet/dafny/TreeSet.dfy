module TreeSet {
    class Set {
        var value : int;
        var left : Set?;
        var right : Set?;

        constructor Set0(value : int) {
            this.value := value;
            this.left := null;
            this.right := null;
        }
    }

    datatype Tree = Leaf | Node(left : Tree, value : int, right : Tree)
        
    function copy(t : Tree) : Tree {
        if(t.Node?)
        then Node(copy(t.left), t.value, copy(t.right))
        else Leaf
    }

    function addElement(t : Tree, i : int) : Tree {
        if(t.Node?)
        then (
            if(i == t.value)
            then copy(t)
            else (
                if(i < t.value)
                then Node(addElement(t.left, i), t.value, copy(t.right))
                else Node(copy(t.left), t.value, addElement(t.right, i))
            )
        )
        else Node(Leaf, i, Leaf)
    }

    function intersect(l : Tree, r : Tree) : Tree {
        if(l.Node?)
        then (
            if(containsElement(r, l.value))
            then addElement(union(intersect(l.left, r), intersect(l.right, r)), l.value)
            else union(intersect(l.left, r), intersect(l.right, r))
        ) 
        else Leaf
    }

    function union(l : Tree, r : Tree) : Tree {
        if(l.Node?) 
        then addElement(union(l.left, union(l.right, r)), l.value)
        else r
    }

    function removeElement(t : Tree, i : int) : Tree {
        if(t.Node?)
        then (
            if(i == t.value)
            then union(t.left, t.right)
            else (
                if(i < t.value)
                then Node(removeElement(t.left, i), t.value, copy(t.right))
                else Node(copy(t.left), t.value, removeElement(t.right, i))
            )
        )
        else Node(Leaf, i, Leaf)
    }

    function containsElement(t : Tree, i : int) : bool {
        if(t.Node?)
        then (
            if(i == t.value)
            then true
            else (
                if(i < t.value)
                then containsElement(t.left, i)
                else containsElement(t.right, i)
            )
        )
        else false
    }

    function size(t : Tree) : (s : int)
    ensures s >= 0 {
        if(t.Node?)
        then size(t.left) + size(t.right) + 1
        else 0
    }
}