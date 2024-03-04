package prac3;

import java.util.*;
import java.util.concurrent.Semaphore;

public class ThreadSafeMap<K, V> implements Map<K, V> {
    private Map<K, V> map = new HashMap<>();
    private Semaphore semaphore = new Semaphore(1);

    @Override
    public Set<Entry<K, V>> entrySet() {
        try {
            semaphore.acquire();
            return map.entrySet();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    @Override
    public V put(K key, V value) {
        try {
            semaphore.acquire();
            return map.put(key, value);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    @Override
    public V get(Object key) {

        try {
            semaphore.acquire();
            return map.get(key);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    @Override
    public int size() {
        try {
            semaphore.acquire();
            return map.size();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    @Override
    public boolean isEmpty() {
        try {
            semaphore.acquire();
            return map.isEmpty();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    @Override
    public boolean containsKey(Object key) {
        try {
            semaphore.acquire();
            return map.containsKey(key);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        } finally {
            semaphore.release();
        }
    }

    @Override
    public boolean containsValue(Object value) {
        try {
            semaphore.acquire();
            return map.containsValue(value);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    @Override
    public V remove(Object key) {
        try {
            semaphore.acquire();
            return map.remove(key);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        try {
            semaphore.acquire();
            map.putAll(m);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    @Override
    public void clear() {
        try {
            semaphore.acquire();
            map.clear();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    @Override
    public Set<K> keySet() {
        try {
            semaphore.acquire();
            return map.keySet();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    @Override
    public Collection<V> values() {
        try {
            semaphore.acquire();
            return map.values();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }
}