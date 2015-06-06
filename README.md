# RecyclerView Animation Test
## At a data change the list should slide Items to the new positions.
#### simple using swapAdapter or notifyDataSetChanged


### 1. All Items need an Id.

```java

    class SampleAdapter extends RecyclerView.Adapter<VH>{
    ...
    @Override
    public long getItemId(int position) {
     return
    }

```

### 2. setHasStableIds at the instance of the adapter

```java

    adapter.setHasStableIds(true);

```



### 3. swap or setList
```java

    private void swapAdapter() {
      /**
       * copy from javaDoc
       * removeAndRecycleExistingViews - If set to true, RecyclerView will recycle all existing Views. If adapters have stable ids
       */
      boolean removeAndRecycleExistingViews=false;
        recyclerView.swapAdapter(createNewAdapter(), removeAndRecycleExistingViews);
    }

    public void setList(){
            ((SampleAdapter)recyclerView.getAdapter()).setList(createNextDummyItems());
    }

```