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
            if(i < t.value)
            then Node(addElement(t.left, i), t.value, copy(t.right))
            else (
                if(i > t.value)
                then Node(copy(t.left), t.value, addElement(t.right, i))
                else copy(t)
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
}