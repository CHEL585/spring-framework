package org.springframework.core.type.myTest;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Date 2021/4/19 10:39
 * @Created by gul
 */
public class TestBean<T> {

	private List<T> a;

	private T b;

	private List c;

	private List<String> d;

	private Map<String,T> map;

	private T[] values;

	private List<? super String>  option;

	public static void main(String[] args) {
		Field[] fields = TestBean.class.getDeclaredFields();
		for (Field field : fields) {
//			System.out.print(field.getGenericType());
//			System.out.print("-----");
//			System.out.println(field.getType());
//			System.out.print("-----");
//			System.out.println();
			if (field.getGenericType() instanceof TypeVariable) {
				TypeVariable typeVariable = (TypeVariable) field.getGenericType();
				System.out.print("typeVariable:" + typeVariable.getName());
				System.out.print("-----");
				System.out.print("typeVariable:" + typeVariable.getTypeName());
				System.out.println();
			}

			if (field.getGenericType() instanceof ParameterizedType) {
				ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
				System.out.print("parameterizedType:" + parameterizedType.getTypeName());
				System.out.print("-----parameterizedType:");
				Arrays.stream(parameterizedType.getActualTypeArguments()).forEach(System.out::print);
				System.out.println();
			}
			if (field.getGenericType() instanceof GenericArrayType) {
				GenericArrayType genericArrayType = (GenericArrayType) field.getGenericType();
				System.out.print("genericArrayType:" + genericArrayType.getTypeName());
				System.out.print("-----genericArrayType:");
				System.out.print(genericArrayType.getGenericComponentType());
				System.out.println();
			}

			if (field.getGenericType() instanceof WildcardType) {
				WildcardType wildcardType = (WildcardType) field.getGenericType();
				System.out.print("wildcardType:" + wildcardType.getTypeName());
				System.out.print("-----wildcardType:");
				System.out.print(wildcardType.getUpperBounds() + "," + wildcardType.getLowerBounds());
				System.out.println();
			}
		}
	}
}
