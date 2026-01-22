# 🌐 API de Traducción Inteligente

<div align="center">

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.x-green?logo=springboot)
![Java](https://img.shields.io/badge/Java-21-blue?logo=openjdk)
![REST API](https://img.shields.io/badge/REST%20API-Enabled-red?logo=rest)
![OpenRouter](https://img.shields.io/badge/OpenRouter-AI%20Powered-purple)
![License](https://img.shields.io/badge/License-MIT-yellow)

**Servicio de traducción automática potenciado por inteligencia artificial**

</div>

## 🎯 ¿Qué hace esta API?

Esta API permite traducir texto entre diferentes idiomas utilizando modelos de inteligencia artificial avanzados a través de OpenRouter. Convierte un texto de entrada en su equivalente traducido al idioma deseado, manteniendo el contexto y significado original.

### Características principales:
- ✅ Traducción entre más de 100 idiomas
- ✅ Auto-detección del idioma de origen
- ✅ Uso de modelos IA como Google Gemini, GPT, Claude
- ✅ Respuesta rápida en formato JSON estándar

## 🚀 Uso rápido

### 1. Ejecutar la API:
```bash
mvn spring-boot:run
```
### 2. Enviar solicitud de traducción:
```bash
curl -X POST http://localhost:8080/api/translate \
  -H "Content-Type: application/json" \
  -d '{
    "text": "Hello world",
    "targetLanguage": "es"
  }'
```

### 3. Respuesta esperada:
```bash
{
  "originalText": "Hello world",
  "translatedText": "Hola mundo",
  "sourceLanguage": "en",
  "targetLanguage": "es",
  "modelUsed": "google/gemini-2.0-flash-exp:free"
}
```

## 🔧 Configuración mínima
Obtén una API key gratuita en: https://openrouter.ai/

### Configura en application.properties:

```properties
openrouter.api.key=tu-api-key-aquí
server.port=8080
```


## 📋 Endpoints disponibles
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/api/translate` | Traduce texto a otro idioma |
| GET | `/api/translate/health` | Verifica estado del servicio |


## 🐳 Ejecutar con Docker
```bash
docker build -t translation-api .
docker run -p 8080:8080 -e OPENROUTER_API_KEY="tu-key" translation-api
```
