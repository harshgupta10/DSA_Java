class RandomizedSet {

    private Map<Integer, Integer> indxMp = null; 
    private List<Integer> arr = null;
    public RandomizedSet() {
        indxMp = new HashMap<>();
        arr = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(indxMp.containsKey(val) && indxMp.get(val) != -1)return false;
        //current size of arraylist will be index on which this val will be inserted
        indxMp.put(val, arr.size());
        arr.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(indxMp.containsKey(val) && indxMp.get(val) != -1){//if this condition holds true then remove the val
        //index in arraylist at which val is present
           int indx =  indxMp.get(val);
           indxMp.put(val, -1);
           if(indx == arr.size()-1){
               arr.remove(arr.size()-1);
               return true;
           }
           if(arr.size() - 1 > 0){
               int arrSz = arr.size();
               int lastEle = arr.get(arrSz-1);
               try{
                    arr.set(indx, lastEle);
               }catch(Exception e){
                    // System.out.println("size: " + arrSz + " indx: "+ indx);
               }  
               indxMp.put(lastEle, indx);
           }
           arr.remove(arr.size()-1);
           return true;
        }else{
            return false;
        }
    }
    
    public int getRandom() {
        int min = 0, max = arr.size()-1;
        int rdIndx = min + (int)(Math.random() * ((max - min) + 1));
        return arr.get(rdIndx);
    }
}
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */