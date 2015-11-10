
public class LazyTree {
	/*
	 * 
	 * **************************************
	 * * SEGMENT TREE WITH LAZY PROPAGATION *
	 * **************************************
	 * 
	 * TEMPLATE: lazytree
	 * 
	 */
	
	
	static long[] tree = new long[4000000];
	 static long[] lazy = new long[4000000];
	 static long[] input = new long[1000000];
	 
	 static void init(int node,int s, int e){
	  if(s==e){
	   tree[node]=input[s];
	   return;
	  }
	  int mid = (s+e)/2;
	  init(node*2+1,s,mid);
	  init(node*2+2,mid+1,e);
	  tree[node] = tree[node*2+1]+tree[node*2+2];
	 }
	 
	 //Para actualizar uno solo de los valores
	 static void update(int node,int s,int e, int i, long val){
	  // index out of range
	  if(i < s || i > e) return;
	  
	  //update the node
	  if(s==e){
	   tree[node] = val;
	   return;
	  }
	  int mid = (s+e)/2;
	  update(node*2+1,s,mid,i,val);
	  update(node*2+2,mid+1,e,i,val);
	  tree[node] = tree[node*2+1]+tree[node*2+2];
	 }
	 
	 //Para hacer queries sin usar lazy prop
	 static  long query(int node,int s, int e, int qs, int qe){
	  if(qe < s || e < qs) return 0; //suma 0 producto 1
	  
	  if(qs <= s && e <= qe){
	   return tree[node];
	  }
	  int mid=(s+e)/2;
	  return query(node*2+1,s,mid,qs,qe)+query(node*2+2,mid+1,e,qs,qe);
	 }
	 
	 //update range hace uso de lazy prop,
	// en este caso suma una valor val a todos los elementos del rango [us,ue]
	 static void update_range(int node,int s, int e, int us, int ue, long val){
	  //Hay actualizaciones lazy q deben hacerse antes 
	  if(lazy[node]!=0){
	   tree[node] += lazy[node];
	   
	   //marcamos los hijos como lazy
	   if(s!=e){
	    lazy[node*2+1] += val;
	    lazy[node*2+2] +=val;
	   }
	   
	   lazy[node] =0; //reseteado el nodo pues ya no es lazy
	  }
	  //fuera de rango
	  if(s> ue || e < us) return;
	  
	  //segmento completamente en rango
	  if(s >=us && e <= ue){
	   tree[node] += (e-s+1)*val;
	   
	   if(s!=e){ // no es nodo hoja, entonces marcamos los hijos como lazy
	    lazy[node*2+1] +=val;
	    lazy[node*2+2] +=val;
	   }
	   
	   return;
	  }
	  
	  int mid = (s+e)/2;
	  
	  update_range(node*2+1, s, mid, us, ue, val);
	  update_range(node*2+2, mid+1, e, us, ue, val);
	  
	  tree[node] = tree[node*2+1]+tree[node*2+2];
	 }
	 
	 static long query_lazy(int node,int s,int e, int qs, int qe){
	  
	  // si hay llamadas lazy pendientes las terminamos
	  if(lazy[node] != 0){
	   tree[node] += (e-s+1)*lazy[node];
	   if(s != e){
	    lazy[node*2+1] += lazy[node];
	    lazy[node*2+2] += lazy[node];
	   } 
	   lazy[node] =0;
	  }

	  if( qe < s || e < qs) return 0;
	  
	  if(s >=qs && e<=qe){
	   return tree[node];
	  }
	  
	  int mid = (s+e)/2;
	  return query_lazy(node*2+1, s, mid, qs, qe)+query_lazy(node*2+2, mid+1, e, qs, qe);
	  
	 }

}
