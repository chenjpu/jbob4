package com.jbob.core.batis.cache;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.cache.CacheException;

public class BatisEhCache implements Cache {

	private final Ehcache ehcache;

	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	public BatisEhCache(Ehcache ehcache) {
		this.ehcache = ehcache;
	}

	public String getId() {
		return ehcache.getName();
	}

	public int getSize() {
		return ehcache.getSize();
	}

	public void putObject(Object key, Object value) {
		ehcache.put(new Element(key, value));
	}

	public Object getObject(Object key) {
		Element e = ehcache.get(key);
		if (e != null) {
			return e.getObjectValue();
		}
		return null;
	}

	public Object removeObject(Object key) {
		return ehcache.remove(key);
	}

	public void clear() {
		ehcache.flush();
	}

	public ReadWriteLock getReadWriteLock() {
		return readWriteLock;
	}

	public boolean equals(Object o) {
		if (getId() == null)
			throw new CacheException("Cache instances require an ID.");
		if (this == o)
			return true;
		if (!(o instanceof Cache))
			return false;

		Cache otherCache = (Cache) o;
		return getId().equals(otherCache.getId());
	}

	public int hashCode() {
		if (getId() == null)
			throw new CacheException("Cache instances require an ID.");
		return getId().hashCode();
	}

}
