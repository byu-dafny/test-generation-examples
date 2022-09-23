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
        
    function copy(t : Tree) : (o : Tree) 
    ensures unique(t) && ordered(t) <==> unique(o) && ordered(o)
    ensures size(t) == size(o)
    {
        if(t.Node?)
        then Node(copy(t.left), t.value, copy(t.right))
        else Leaf
    }

    function addElement(t : Tree, i : int) : (o : Tree) 
    requires unique(t) && ordered(t) 
    ensures  containsElement(o, i) 
    requires unique(o) && ordered(o) 
    ensures  (containsElement(t, i) && size(t) == size(o)) || size(t) + 1 == size(o)
    {
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

    function intersect(l : Tree, r : Tree) : (t : Tree)  
    requires unique(l) && ordered(l)  
    requires unique(r) && ordered(r) 
    ensures  unique(t) && ordered(t)
    ensures  forall i :: l.containsElement(i) && r.containsElement(i) ==> t.containsElement(i)
    ensures  size(l) + size(r) - size(union(l, r)) == size(t)
    {
        if(l.Node?)
        then (
            if(containsElement(r, l.value))
            then addElement(union(intersect(l.left, r), intersect(l.right, r)), l.value)
            else union(intersect(l.left, r), intersect(l.right, r))
        ) 
        else Leaf
    }

    function union(l : Tree, r : Tree) : (t : Tree) 
    requires unique(l) && ordered(l) 
    requires unique(r) && ordered(r)  
    ensures  unique(t) && ordered(t)
    ensures  forall i :: l.containsElement(i) || r.containsElement(i) ==> t.containsElement(i)
    ensures  size(l) + size(r) - size(intersect(t)) == size(t)
    {
        if(l.Node?) 
        then addElement(union(l.left, union(l.right, r)), l.value)
        else r
    }

    function difference(l : Tree, r : Tree) : (t : Tree)
    requires unique(l) && ordered(l) 
    requires unique(r) && ordered(r)
    ensures  unique(t) && ordered(t)
    ensures  forall i :: l.containsElement(i) && !r.containsElement(i) ==> t.containsElement(i)
    ensures  size(l) - size(intersect(l, r)) == size(t)
    {
        if(l.Node?)
        then (
            if(!containsElement(r, l.value))
            then addElement(union(difference(l.left, r), difference(l.right, r)), l.value)
            else union(difference(l.left, r), difference(l.right, r))
        )
        else Leaf
    }

    function removeElement(t : Tree, i : int) : (o : Tree) 
    requires unique(t) && ordered(t)
    ensures  !containsElement(o, i)
    ensures  unique(o) && ordered(o)
    ensures  (containsElement(t, i) && size(t) + 1 == size(o)) || size(t) == size(o)
    {
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

    function containsElement(t : Tree, i : int) : bool  
    requires unique(t) && ordered(t)
    {
        t.Node? && (i == t.value || (
            if(i < t.value)
            then containsElement(t.left, i)
            else containsElement(t.right, i)
        ))
    }
    
    function lesser(t : Tree, i : int) : bool {
        t.Leaf? || (i < t.value && lesser(t.left, i) && lesser(t.right, i))
    }
    function greater(t : Tree, i : int) : bool {
        t.Leaf? || (i > t.value && greater(t.left, i) && greater(t.right, i))
    }
    function ordered(t : Tree) : bool {
        if(t.Node?)
        then greater(t.left, t.value) && lesser(t.right, t.value)
        else true
    }

    function count(t : Tree, i : int) : (count : int) 
    ensures count >= 0
    {
        if(t.Node?)
        then (if(t.value == i) then 1 else 0) + count(t.left, i) + count(t.right, i)
        else 0
    }

    function unique(t : Tree) : bool {
        if(t.Node?)
        then count(t, t.value) == 1 && unique(t.left) && unique(t.right)
        else true
    }

    function size(t : Tree) : (s : int)
    ensures s >= 0
    {
        if(t.Node?)
        then size(t.left) + size(t.right) + 1
        else 0
    }
}