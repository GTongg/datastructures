# A complete working Python program to demonstrate all 
# insertion methods of linked list 
  
# Node class 
class Node: 
  
    # Function to initialise the node object 
    def __init__(self, data): 
        self.data = data  # Assign data 
        self.next = None  # Initialize next as null 
    def __repr__(self):
        return repr(self.data)
  
  
# Linked List class contains a Node object 
class LinkedList: 
  
    # Function to initialize head 
    def __init__(self): 
        self.head = None
        self.n = 0
        self.tail = None
  
    # Functio to insert a new node at the beginning 
    def push(self, new_data): 
  
        # 1 & 2: Allocate the Node & 
        #        Put in the data 
        new_node = Node(new_data) 
  
        # 3. Make next of new Node as head 
        new_node.next = self.head 
  
        # 4. 移動頭部指向新節點
        自我。頭 = 新節點  
        self.n += 1
        #if self.n==1: self.tail=new_node
        #return self
        if self.tail is None:
            self.tail = new_node

    # This function is in LinkedList class. Inserts a 
    # new node after the given prev_node. This method is 
    # defined inside LinkedList class shown above */ 
    def insertAfter(self, prev_node, new_data): 
  
        # 1. check if the given prev_node exists 
        if prev_node is None: 
            print ("The given previous node must in the Linked List.")
            return
  
        #  2. create new node & 
        #      Put in the data 
        new_node = Node(new_data) 
  
        # 4. Make next of new Node as next of prev_node 
        new_node.next = prev_node.next
  
        # 5. make next of prev_node as new_node 
        prev_node.next = new_node 
        self.n += 1
        if prev_node==self.tail: self.tail=new_node
    
    # This function is defined in Linked List class 
    # Appends a new node at the end.  This method is 
    # defined inside LinkedList class shown above */ 
    def append(self, new_data): 
  
        # 1. Create a new node 
        # 2. Put in the data 
        # 3. Set next as None 
        new_node = Node(new_data)
        
        # 4. If the Linked List is empty, then make the 
        #    new node as head 
        if self.head is None: 
            self.head = new_node 
        else:
            self.tail.next=new_node

        self.tail=new_node
        self.n += 1 
        return self

    # Utility function to print the linked list 
    def printList(self): 
        q = self.head 
        while q: 
            print(q) 
            q = q.next

    def __repr__(self):
        res=[]
        q = self.head 
        while q: 
            res.append(str(q))
            q = q.next

        return '['+', '.join(res)+']'

    def heads(self, n=5):  # you should change head to heads
        res=[]
        q = self.head 
        i=0
        while q and i<n: 
            res.append(str(q))
            i+=1
            q = q.next
        return '['+', '.join(res)+']'

if __name__ == '__main__':
   ll = LinkedList()
   ll.push(5)
   ll.push(10)
   ll.push(15)
   print('使用物件方法printList()')
   ll.printList()
   print('使用物件方法repr')
   print(ll)
   print('使用物件方法heads')
   print(ll.heads())
   print(f'執行ll.append(11).append(22).append(33)')
   ll.append(11).append(22).append(33)
   print(f'll現在為{ll}')
   for i in range(6, -3, -1):
       print(f'前{i}個元素: {ll.heads(i)}')
