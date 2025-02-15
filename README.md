# Spring Boot Chat Application with DeepSeek and Ollama

Aplicación de chat inteligente construida con **Spring Boot** que integra el modelo de lenguaje **DeepSeek** ejecutado localmente mediante **Ollama**. Ideal para experimentar con IA conversacional en entornos privados o de desarrollo.

[![chat-Deep-Seek.png](https://i.postimg.cc/nr4f89fN/chat-Deep-Seek.png)](https://postimg.cc/zHGcKBBk)

## ✨ Características

- **Integración con Ollama**: Ejecución local del modelo DeepSeek sin dependencias externas.
- **Chat en Tiempo Real**: Interfaz web responsive con streaming de respuestas.
- **Spring AI**: Uso de la librería oficial de Spring para integración con modelos de IA.
- **Configuración Flexible**: Soporta múltiples modelos y ajustes de parámetros.
- **Privacidad**: Todos los datos procesados localmente.

## 📋 Prerrequisitos

- Java 17+
- Spring Boot 3.2+
- Maven/Gradle
- Ollama instalado ([Guía de instalación](https://ollama.ai/))
- 8GB+ RAM (Recomendado para modelos grandes)

## 🚀 Instalación

1. **Clonar repositorio**:
```bash
git clone https://github.com/JonStevenBernal/spring-deepseek-chat.git
```

2. **Instalar dependencias**:

```bash
ollama pull deepseek-r1:1.5b
```

Desarrollado por **JonStevenBernal** | [Documentación Spring AI](https://chat.deepseek.com/a/chat/s/9280548d-efcb-4961-842f-3cc00651be25 "Permalink to DeepSeek")
